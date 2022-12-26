package com.olga.olga.mapping;

import com.olga.olga.dto.CurrencyDto;
import com.olga.olga.entity.Currency;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper {
    public Currency mapToCurrency(CurrencyDto currencyDto) {
        Currency currency = new Currency();
        currency.setCode(currencyDto.getCode());
        currency.setId(currencyDto.getId());
        currency.setProductList(currencyDto.getProductList());
        return currency;
    }
}
