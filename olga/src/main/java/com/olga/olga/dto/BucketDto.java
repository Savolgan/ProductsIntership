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
public class BucketDto {
    private String name;
    Integer userId;
    private List<Product> productList;
}
