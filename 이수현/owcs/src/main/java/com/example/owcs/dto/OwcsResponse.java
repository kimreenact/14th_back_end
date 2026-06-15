package com.example.owcs.dto;

import com.example.owcs.domain.Owcs;
import io.swagger.v3.oas.annotations.media.Schema;

public record OwcsResponse(
        @Schema(description = "ID",example = "14")
        Long id,

        @Schema(description = "Team",example = "Lunatic-Hai")
        String team,

        @Schema(description = "Nickname",example = "RYUJEHONG")
        String nickname,

        @Schema(description = "Position",example = "Healer")
        String position,

        @Schema(description = "heros",example = "Ana")
        String heros
)
{
    public static OwcsResponse from(Owcs owcs){
        return new OwcsResponse(
                owcs.getId(),
                owcs.getTeam(),
                owcs.getNickname(),
                owcs.getPosition(),
                owcs.getHeros()

            );
        }
    }

