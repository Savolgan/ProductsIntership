package com.olga.olga.mapping;

import com.olga.olga.dto.ProductDto;
import com.olga.olga.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapToProduct(ProductDto productDto){
        Product product=new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCurrency(productDto.getCurrency());
        return product;
    }
}
