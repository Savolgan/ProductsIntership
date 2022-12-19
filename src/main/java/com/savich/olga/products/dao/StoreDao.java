package com.savich.olga.products.dao;

import com.savich.olga.products.entity.Store;
import org.springframework.data.repository.CrudRepository;

public interface StoreDao extends CrudRepository<Store,Integer> {
}
