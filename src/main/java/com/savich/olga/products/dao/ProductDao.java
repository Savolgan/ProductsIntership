package com.savich.olga.products.dao;

import com.savich.olga.products.entity.Bucket;
import com.savich.olga.products.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao  extends CrudRepository<Product,Integer> {
}
