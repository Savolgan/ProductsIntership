package com.savich.olga.products.mapping;

import com.savich.olga.products.dto.CurrencyDto;
import com.savich.olga.products.entity.Currency;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper {
    public Currency mapToCurrency(CurrencyDto currencyDto) {
        Currency currency = new Currency();
        currency.setCode(currencyDto.getCode());
        currency.setName(currencyDto.getName());
        currency.setCourse(currencyDto.getCourse());
        currency.setMultiplicity(currencyDto.getMultiplicity());
        return currency;
    }
}
