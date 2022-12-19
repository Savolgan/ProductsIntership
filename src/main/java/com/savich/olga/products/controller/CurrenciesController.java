package com.savich.olga.products.controller;

import com.savich.olga.products.dto.CurrencyDto;
import com.savich.olga.products.entity.Currency;
import com.savich.olga.products.service.CurrencyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrenciesController {
    private final CurrencyService currencyService;

    public CurrenciesController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @GetMapping("/get/{id}")
    public Currency getCurrency(@PathVariable(value = "id") int id) {
        return currencyService.getCurrencyById(id);
    }

    @PostMapping("/save")
    public Currency saveCurrency(@RequestBody CurrencyDto currencyDto) {
        return currencyService.saveCurrency(currencyDto);
    }

    @PutMapping("/update/{id}")
    public void updateCurrency(@PathVariable(value = "id") int id, @RequestBody CurrencyDto currencyDto) {
        currencyService.updateCurrency(id, currencyDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCurrency(@PathVariable(value = "id") int id) {
        currencyService.deleteCurrencyById(id);
    }
}
