package com.example.posts.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record PostRequest(
    @Schema(description = "게시글 제목", example = "첫 번째 게시글")
    String title,

    @Schema(description = "게시글 내용", example = "안녕하세요")
    String content,

    @Schema(description = "작성자", example = "서준")
    String author
){}
