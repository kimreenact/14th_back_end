package com.example.owcs.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record OwcsUpdateRequest(
        @Schema(description = "Update Team",example ="T1")
        String team,

        @Schema(description = "Update Nickname",example = "DONGHAK")
        String nickname,

        @Schema(description = "Update position",example = "Tanker")
        String position,

        @Schema(description = "Update heros",example = "Wrecking ball")
        String heros

) {
}
