package com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Response;

import com.likeLion.LikeLion_SpringBoot_Assignment.Domain.Post;
import io.swagger.v3.oas.annotations.media.Schema;

public record NoticeBoardResponseDTO (
        @Schema(description = "게시글 ID", example = "1")
        Long id,

        @Schema(description = "게시글 이름", example = "첫 번째 게시글")
        String title,

        @Schema(description = "게시글 내용", example = "안녕하세요.")
        String Content,

        @Schema( description = "작성자", example = "홍길동")
        String autor
){
    public static NoticeBoardResponseDTO from(Post post) {
        return new NoticeBoardResponseDTO(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
    }
}
