package com.olga.olga.service;

import com.olga.olga.dao.CurrencyDao;
import com.olga.olga.dto.CurrencyDto;
import com.olga.olga.entity.Currency;
import com.olga.olga.mapping.CurrencyMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyDao currencyDao;
    private final CurrencyMapper currencyMapper;

    public List<Currency> getAllCurrencies() {
        List<Currency> currencyList = new ArrayList<>();
        currencyDao.findAll().forEach(currency -> currencyList.add(currency));
        return currencyList;
    }

    public Currency saveCurrency(CurrencyDto currencyDto) {
        return currencyDao.save(currencyMapper.mapToCurrency(currencyDto));
    }

    public Currency getCurrencyById(Integer id) throws ClassNotFoundException {
        return currencyDao.findById(id).orElseThrow(() ->
                new ClassNotFoundException("Currency not found, id is incorrect"));
    }


}
