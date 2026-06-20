package com.example.week08hw.dto.response;

import com.example.week08hw.entity.Store;
import io.swagger.v3.oas.annotations.media.Schema;

public record StoreResponseDto(
        @Schema(description = "편의점 ID", example = "1")
        Long id,

        @Schema(description = "편의점 이름", example = "CU 명지대점")
        String name
) {
    public static StoreResponseDto from(Store store) {
        return new StoreResponseDto(
                store.getId(),
                store.getName()
        );
    }
}