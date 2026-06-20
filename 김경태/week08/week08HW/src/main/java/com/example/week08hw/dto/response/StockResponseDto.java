package com.example.week08hw.dto.response;

import com.example.week08hw.entity.Stock;
import io.swagger.v3.oas.annotations.media.Schema;

public record StockResponseDto(
        @Schema(description = "상품 ID", example = "1")
        Long id,

        @Schema(description = "편의점 ID", example = "1")
        Long storeId,

        @Schema(description = "상품 이름", example = "위도우 제인")
        String productName,

        @Schema(description = "상품 가격", example = "500")
        int price,

        @Schema(description = "상품 수량", example = "500")
        int quantity
) {
    public static StockResponseDto from(Stock stock) {
        return new StockResponseDto(
                stock.getId(),
                stock.getStoreId(),
                stock.getProductName(),
                stock.getPrice(),
                stock.getQuantity()
        );
    }
}