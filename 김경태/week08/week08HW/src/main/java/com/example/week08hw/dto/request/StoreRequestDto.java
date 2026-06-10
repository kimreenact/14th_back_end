package com.example.week08hw.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record StoreRequestDto(
        @Schema(description = "편의점 이름", example = "CU 명지대점")
        String name
) {
}