package com.example.post.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 게시글 도메인 객체.
 * DB 없이 인메모리(Map)로 저장하는 단순 객체이며, Lombok 으로 getter/setter 를 생성한다.
 */
@Getter
@Setter
@NoArgsConstructor
public class Post {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }
}
