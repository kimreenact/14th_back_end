package com.example.post.dto;

import com.example.post.domain.Post;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * 게시글 응답 DTO.
 * 도메인(Post)을 직접 노출하지 않고 응답 전용 DTO로 변환하여 반환한다.
 */
@Schema(description = "게시글 응답 DTO")
public record PostResponse(

        @Schema(description = "게시글 ID", example = "1")
        Long id,

        @Schema(description = "게시글 제목", example = "첫 번째 게시글")
        String title,

        @Schema(description = "게시글 내용", example = "안녕하세요. 첫 게시글 내용입니다.")
        String content,

        @Schema(description = "작성자", example = "홍길동")
        String author,

        @Schema(description = "생성 일시", example = "2025-06-15T10:00:00")
        LocalDateTime createdAt,

        @Schema(description = "수정 일시", example = "2025-06-15T10:30:00")
        LocalDateTime updatedAt
) {

    /**
     * Post 도메인 객체를 PostResponse DTO 로 변환한다.
     */
    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }
}
