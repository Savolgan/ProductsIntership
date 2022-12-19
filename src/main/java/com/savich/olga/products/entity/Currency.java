package com.savich.olga.products.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "currencies")
public class Currency {
    private Integer id;
    @Column
    private String code;
    @Column
    private String name;
    @Column
    private BigDecimal course;
    @Column
    private Integer multiplicity;
    private List<Product> productList;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Product> getProductList() {
        return productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCourse() {
        return course;
    }

    public void setCourse(BigDecimal course) {
        this.course = course;
    }

    public Integer getMultiplicity() {
        return multiplicity;
    }

    public void setMultiplicity(Integer multiplicity) {
        this.multiplicity = multiplicity;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
