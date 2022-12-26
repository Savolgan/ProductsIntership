package com.olga.olga.dao;

import com.olga.olga.entity.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyDao extends CrudRepository<Currency,Integer> {
}
