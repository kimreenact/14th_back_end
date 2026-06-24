package com.example.post.exception;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * 예외 발생 시 일관된 형태로 반환할 에러 응답 DTO.
 */
@Schema(description = "에러 응답 DTO")
public record ErrorResponse(

        @Schema(description = "HTTP 상태 코드", example = "404")
        int status,

        @Schema(description = "에러 메시지", example = "해당 게시글을 찾을 수 없습니다. id=999")
        String message,

        @Schema(description = "에러 발생 시각", example = "2025-06-15T10:00:00")
        LocalDateTime timestamp
) {

    public static ErrorResponse of(int status, String message) {
        return new ErrorResponse(status, message, LocalDateTime.now());
    }
}
