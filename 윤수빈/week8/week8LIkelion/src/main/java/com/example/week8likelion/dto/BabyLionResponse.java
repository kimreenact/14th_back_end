package com.example.week8likelion.dto;

import com.example.week8likelion.domain.BabyLion;
import io.swagger.v3.oas.annotations.media.Schema;

public record BabyLionResponse(

        @Schema(description = "아기 사자 ID", example = "1")
        Long id,

        @Schema(description = "아기 사자 이름", example = "현준")
        String name,

        @Schema(description = "아기 사자 나이", example = "23")
        int age,

        @Schema(description = "아기 사자 파트", example = "BACKEND")
        String part
) {
    public static BabyLionResponse from(BabyLion babyLion) {
        return new BabyLionResponse(
                babyLion.getId(),
                babyLion.getName(),
                babyLion.getAge(),
                babyLion.getPart()
        );
    }
}
