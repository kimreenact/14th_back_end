package com.example.postapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record PostUpdateRequest(

        @Schema(description = "수정할 게시글 제목", example = "수정된 제목")
        String title,

        @Schema(description = "수정할 게시글 내용", example = "수정된 내용")
        String content,

        @Schema(description = "수정할 작성자", example = "현준")
        String author
) {
}
