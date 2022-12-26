package com.olga.olga.service;

import com.olga.olga.LogInFile;
import com.olga.olga.dao.ProductDao;
import com.olga.olga.dto.ProductDto;
import com.olga.olga.entity.Product;
import com.olga.olga.mapping.ProductMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao productDao;
    private final ProductMapper productMapper;

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        productDao.findAll().forEach(product -> productList.add(product));
        return productList;
    }

    public Product getProductById(int id) throws ClassNotFoundException {
        return productDao.findById(id).orElseThrow(() ->
                new ClassNotFoundException("Product not found, id is incorrect"));
    }

    public Product saveProduct(ProductDto productDto) throws IOException {
        String string = "The product  " + productDto.getName() + " is added to table" + "\n";
        LogInFile.logInFile(string);
        System.out.println("The product  " + productDto.getName() + " is added to table" + "\n");
        return productDao.save(productMapper.mapToProduct(productDto));
    }
    public List<Product> getProductsByName(String name) {
       return productDao.findByName(name);
    }
    public  List<Product> findByPrice(BigDecimal price){
        return productDao.findByPrice(price);
    }

    public  List<Product> findByPriceLessThat(BigDecimal price){
        return productDao.findByPriceLessThat(price);
    }
}
