package com.example.posts.dto;

import com.example.posts.domain.Post;
import io.swagger.v3.oas.annotations.media.Schema;

public record PostResponse(

        @Schema(description = "게시글 ID", example = "1")
        Long id,

        @Schema(description = "게시글 제목", example = "첫 번째 게시글")
        String title,

        @Schema(description = "게시글 내용", example = "안녕하세요")
        String content,

        @Schema(description = "작성자", example = "서준")
        String author
) {
    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor()
        );
    }
}