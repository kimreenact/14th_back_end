package com.example.week08hw.dto.response;

import com.example.week08hw.entity.Stock;
import io.swagger.v3.oas.annotations.media.Schema;

public record ProductResponseDto(
        @Schema(description = "상품 ID", example = "1")
        Long id,

        @Schema(description = "상품 이름", example = "위도우 제인")
        String productName,

        @Schema(description = "상품 수량", example = "500")
        int quantity
) {
    public static ProductResponseDto from(Stock stock) {
        return new ProductResponseDto(
                stock.getId(),
                stock.getProductName(),
                stock.getQuantity()
        );
    }
}