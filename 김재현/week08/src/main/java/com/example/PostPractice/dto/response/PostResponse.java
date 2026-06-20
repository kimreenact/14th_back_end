package com.example.PostPractice.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostResponse {

    @Schema(description = "게시글 번호", example = "1")
    private Long id;

    @Schema(description = "게시글 제목", example = "첫 글입니다")
    private String title;

    @Schema(description = "작성자", example = "재현")
    private String author;

    @Schema(description = "본문 내용", example = "안녕하세요")
    private String content;
}
