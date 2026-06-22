package com.example.week09hw.dto.response;

import com.example.week09hw.entity.Car;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDto {

    private Long id;
    private String brand;
    private String model;
    private int price;
    private boolean sold;

    public static ResponseDto from(Car car) {
        return ResponseDto.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .price(car.getPrice())
                .sold(car.getSold())
                .build();
    }
}
