package com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Request;

import io.swagger.v3.oas.annotations.media.Schema;

public record NoticeBoardCreateDTO(
        @Schema(description = "게시글 제목", example = "제목")
        String title,

        @Schema(description = "게시글 내용", example = "안녕하세요")
        String content,

        @Schema(description = "작성자", example = "홍길동")
        String author
) {

}
