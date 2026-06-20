package com.example.PostPractice.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequest {
    @Schema(description = "수정할 제목 (변경 안 하려면 생략)", example = "수정된 제목")
    private String title;

    @Schema(description = "수정할 작성자 (변경 안 하려면 생략)", example = "재현")
    private String author;

    @Schema(description = "수정할 본문 (변경 안 하려면 생략)", example = "수정된 내용")
    private String content;
}
