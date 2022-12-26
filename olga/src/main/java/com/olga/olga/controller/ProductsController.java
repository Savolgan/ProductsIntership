package com.olga.olga.controller;

import com.olga.olga.dto.ProductDto;
import com.olga.olga.entity.Product;
import com.olga.olga.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody ProductDto productDto) throws IOException {
        return productService.saveProduct(productDto);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/byName/{name}")
    public List<Product> getProductsByMame(@PathVariable(value = "name") String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/byPrice/{price}")
    public List<Product> getProductsByPrice(@PathVariable(value = "price") BigDecimal price) {
        return productService.findByPrice(price);
    }

    @GetMapping("/byPriceLess/{price}")
    public List<Product> getProductsByPriceLessThat(@PathVariable(value = "price") BigDecimal price) {
        return productService.findByPriceLessThat(price);
    }
}
