package com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Response;

import com.likeLion.LikeLion_SpringBoot_Assignment.Domain.Car;
import io.swagger.v3.oas.annotations.media.Schema;

public record CarResponseDTO(
        @Schema(description = "식별 ID", example = "1")
        Long id,

        @Schema(description = "브랜드명", example = "BMW")
        String brand,

        @Schema(description = "모델명", example = "X5")
        String model,

        @Schema(description = "가격", example = "80,000,000")
        int price,

        @Schema(description = "판매여부", example = "true")
        boolean isSold
) {
    public static CarResponseDTO from(Car savedCar) {
        return new CarResponseDTO(savedCar.getId(), savedCar.getBrand(), savedCar.getModel(), savedCar.getPrice(), savedCar.isSold());
    }
}
