package com.example.week08hw.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stock {
    private Long id;
    private Long storeId;
    private String productName;
    private int price;
    private int quantity;

    public Stock(Long id, Long storeId, String productName, int price, int quantity) {
        this.id = id;
        this.storeId = storeId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
}
