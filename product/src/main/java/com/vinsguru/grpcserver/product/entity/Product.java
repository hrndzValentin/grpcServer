package com.vinsguru.grpcserver.product.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;

@Document(collection = "Product")
public class Product {

    @Id
    private int id;
    private String code;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String code, String name, double price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
