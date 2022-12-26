package com.olga.olga.dao;

import com.olga.olga.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDao extends CrudRepository<Product, Integer> {
// Можно двумя способами:
    //1-i
//    @Query("SELECT p FROM Product p where p.name = :productName")
//    List<Product> findByName(@Param("productName") String productName);
    //2-i
    List<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.price = :productPrice")
    List<Product> findByPrice(@Param("productPrice") BigDecimal productPrice);

    @Query("SELECT p FROM Product p WHERE p.price < :productPrice")
    List<Product> findByPriceLessThat(@Param("productPrice") BigDecimal productPrice);
}
