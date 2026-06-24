package com.example.week09hw.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private  String brand;
    private String model;
    private int price;
}
