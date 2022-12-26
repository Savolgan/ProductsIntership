package com.olga.olga.dto;


import com.olga.olga.entity.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrencyDto {
    private Integer id;
    private String code;
    private List<Product> productList;

}
