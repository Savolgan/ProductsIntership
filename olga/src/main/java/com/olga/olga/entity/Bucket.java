package com.olga.olga.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "buckets")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bucket {
    public Integer id;
    public String name;
    List<Product> productList;
    public User user;
    UUID uuid;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_bucket",
            joinColumns = @JoinColumn(name = "bucket_id "),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   // @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }
}
