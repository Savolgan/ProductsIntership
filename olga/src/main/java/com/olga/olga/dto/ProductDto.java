package com.olga.olga.dto;

import com.olga.olga.entity.Bucket;
import com.olga.olga.entity.Currency;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    String name;
    BigDecimal price;
    List<Bucket> basketList;
    Currency currency;
}
