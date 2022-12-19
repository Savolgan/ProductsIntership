package com.savich.olga.products.service;

import com.savich.olga.products.dao.CurrencyDao;
import com.savich.olga.products.dto.BucketDto;
import com.savich.olga.products.dto.CurrencyDto;
import com.savich.olga.products.entity.Bucket;
import com.savich.olga.products.entity.Currency;
import com.savich.olga.products.exception.CurrencyNotFoundException;
import com.savich.olga.products.mapping.CurrencyMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {
    private final CurrencyDao currencyDao;
    private final CurrencyMapper currencyMapper;

    public CurrencyService(CurrencyDao currencyDao, CurrencyMapper currencyMapper) {
        this.currencyDao = currencyDao;
        this.currencyMapper = currencyMapper;
    }

    public Currency saveCurrency(CurrencyDto currencyDto) {
        return currencyDao.save(currencyMapper.mapToCurrency(currencyDto));
    }


    public void updateCurrency(int id, CurrencyDto currencyDto) {
        Currency currency = currencyMapper.mapToCurrency(currencyDto);
        currency.setId(id);
        currencyDao.save(currency);
    }

    public void deleteCurrencyById(int id) {
        currencyDao.deleteById(id);
    }

    public Currency getCurrencyById(int id) {
        return currencyDao.findById(id).orElseThrow(() ->
                new CurrencyNotFoundException("Currency not found, id is incorrect"));
    }

    public List<Currency> getAllCurrencies() {
        List<Currency> currencyList = new ArrayList<>();
        currencyDao.findAll().forEach(currency -> currencyList.add(currency));
        return currencyList;
    }
}
