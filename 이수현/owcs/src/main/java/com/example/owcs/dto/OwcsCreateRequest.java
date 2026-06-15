package com.example.owcs.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record OwcsCreateRequest (
    @Schema(description = "Team",example = "Lunatic-Hai")
    String team,

    @Schema(description = "Nickname",example = "RYUJEHONG")
    String nickname,

    @Schema(description = "Position",example = "healer")
    String position,

    @Schema(description = "Heros",example = "ana")
    String heros


){

}
