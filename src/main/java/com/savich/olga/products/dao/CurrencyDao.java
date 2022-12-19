package com.savich.olga.products.dao;

import com.savich.olga.products.entity.Bucket;
import com.savich.olga.products.entity.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyDao extends CrudRepository<Currency,Integer> {
}
