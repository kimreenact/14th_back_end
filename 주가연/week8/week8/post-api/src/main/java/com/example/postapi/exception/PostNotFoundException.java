package com.example.postapi.exception;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(Long id) {
        super("존재하지 않는 게시글입니다. id=" + id);
    }
}
