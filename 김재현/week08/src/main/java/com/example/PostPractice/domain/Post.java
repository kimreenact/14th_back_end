package com.example.PostPractice.domain;

import lombok.Getter;

@Getter
public class Post {
    private Long id;
    private String title;
    private String author;
    private String content;

    public Post(Long id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public void update(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }
}
