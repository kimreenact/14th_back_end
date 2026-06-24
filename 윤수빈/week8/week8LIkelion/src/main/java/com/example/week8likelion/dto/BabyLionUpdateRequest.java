package com.example.week8likelion.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record BabyLionUpdateRequest(

        @Schema(description = "수정할 아기 사자 이름", example = "현준")
        String name,

        @Schema(description = "수정할 아기 사자 나이", example = "24")
        int age,

        @Schema(description = "수정할 아기 사자 파트", example = "SERVER")
        String part
) {
}