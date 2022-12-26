package com.olga.olga.controller;

import com.olga.olga.dto.CurrencyDto;
import com.olga.olga.entity.Currency;
import com.olga.olga.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrenciesController {
    private final CurrencyService currencyService;

    @GetMapping
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @GetMapping("/get/{id}")
    public Currency getCurrencyById(@PathVariable(value = "id") int id) throws ClassNotFoundException {

        return currencyService.getCurrencyById(id);
    }

    @PostMapping("/save")
    public Currency saveCurrency(@RequestBody CurrencyDto currencyDto) {
        return currencyService.saveCurrency(currencyDto);
    }

}
