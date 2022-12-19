package com.savich.olga.products.dto;

;
import com.savich.olga.products.entity.Bucket;
import com.savich.olga.products.entity.FoodTypes;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProductDto {
    private String name;
    private BigDecimal price;
    private LocalDate expiredDate;
    @Enumerated(EnumType.STRING)
    private FoodTypes foodTypes;

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public FoodTypes getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(FoodTypes foodTypes) {
        this.foodTypes = foodTypes;
    }

}
