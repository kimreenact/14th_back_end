package com.example.cafe.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {
    private Long id;
    private String name;
    private int price;
    private String category;
}

