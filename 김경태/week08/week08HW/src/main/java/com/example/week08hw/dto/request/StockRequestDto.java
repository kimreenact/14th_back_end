package com.example.week08hw.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record StockRequestDto(
        @Schema(description = "상품 이름", example = "조니워커 블랙")
        String productName,

        @Schema(description = "상품 가격", example = "500")
        int price,

        @Schema(description = "상품 수량", example = "500")
        int quantity
) {
}