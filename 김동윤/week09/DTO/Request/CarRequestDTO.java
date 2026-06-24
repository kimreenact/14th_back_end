package com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Request;

import com.likeLion.LikeLion_SpringBoot_Assignment.Domain.Car;
import io.swagger.v3.oas.annotations.media.Schema;

public record CarRequestDTO(
        @Schema(description = "브랜드명", example = "BMW")
        String brand,
        @Schema(description = "모델명", example = "X5")
        String model,
        @Schema(description = "가격", example = "80000000")
        int price
) {
    public Car toEntity() {
        return new Car(brand, model, price);
    }
}
