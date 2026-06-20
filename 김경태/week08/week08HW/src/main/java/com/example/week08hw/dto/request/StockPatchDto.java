package com.example.week08hw.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record StockPatchDto (
        @Schema(description = "상품 수량", example = "500")
        int quantity
) {
}