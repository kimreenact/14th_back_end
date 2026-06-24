package com.example.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 게시글 수정 요청 DTO.
 * PATCH 부분 수정을 위해 모든 필드는 선택값(null 허용)이며, null 이 아닌 필드만 수정에 반영된다.
 */
@Schema(description = "게시글 수정 요청 DTO (부분 수정 가능)")
public record PostUpdateRequest(

        @Schema(description = "수정할 제목 (변경하지 않으려면 생략)", example = "수정된 제목")
        String title,

        @Schema(description = "수정할 내용 (변경하지 않으려면 생략)", example = "수정된 내용입니다.")
        String content
) {
}
