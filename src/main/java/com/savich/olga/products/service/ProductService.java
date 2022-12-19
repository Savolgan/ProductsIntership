package com.savich.olga.products.service;

import com.savich.olga.products.dao.ProductDao;
import com.savich.olga.products.dto.ProductDto;
import com.savich.olga.products.entity.Product;
import com.savich.olga.products.exception.ProductNotFoundException;
import com.savich.olga.products.mapping.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductDao productDao;
    private final ProductMapper productMapper;

    public ProductService(ProductDao productDao, ProductMapper productMapper) {
        this.productDao = productDao;
        this.productMapper = productMapper;
    }

    public Product saveProduct(ProductDto productDto) {
        return productDao.save(productMapper.mapToProduct(productDto));
    }

    public void updateProduct(Integer id, ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        product.setId(id);
        productDao.save(product);
    }

    public void deleteProductById(Integer id) {
        productDao.deleteById(id);
    }

    public Product getProductById(Integer id) {
        return productDao.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product not found, id is incorrect"));
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        productDao.findAll().forEach(product -> productList.add(product));
        return productList;
    }
}
