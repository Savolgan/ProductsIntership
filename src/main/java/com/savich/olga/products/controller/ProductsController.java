package com.savich.olga.products.controller;

import com.savich.olga.products.dto.ProductDto;
import com.savich.olga.products.entity.Product;
import com.savich.olga.products.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable(value = "id") int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable(value = "id") int id, @RequestBody ProductDto productDto) {
        productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable(value = "id") int id) {
        productService.deleteProductById(id);
    }
}
