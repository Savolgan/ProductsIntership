package com.savich.olga.products.mapping;

import com.savich.olga.products.dto.ProductDto;
import com.savich.olga.products.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setFoodTypes(productDto.getFoodTypes());
        product.setExpiredDate(productDto.getExpiredDate());
//        product.setCurrency(productDto.getId_currency());
//        product.setStore(productDto.getId_store());

        return product;
    }
}
