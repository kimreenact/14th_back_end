package com.example.week7.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuRequestDto {
    private String name;
    private int price;
    private String category; // COFFEE, ADE, TEA, DESSERT
}