package com.example.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * 게시글 생성 요청 DTO. (키워드: Java Record, DTO)
 */
@Schema(description = "게시글 생성 요청 DTO")
public record PostCreateRequest(

        @Schema(description = "게시글 제목", example = "첫 번째 게시글")
        @NotBlank(message = "제목은 필수입니다.")
        String title,

        @Schema(description = "게시글 내용", example = "안녕하세요. 첫 게시글 내용입니다.")
        @NotBlank(message = "내용은 필수입니다.")
        String content,

        @Schema(description = "작성자", example = "홍길동")
        @NotBlank(message = "작성자는 필수입니다.")
        String author
) {
}
