package com.example.cafe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {
    private Long id;
    private String name;
    private int price;
    private String category; // COFFEE, ADE, TEA, DESSERT

    public Menu(Long id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
