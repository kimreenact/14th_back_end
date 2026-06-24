package com.example.post.exception;

/**
 * 존재하지 않는 게시글 id로 조회/수정/삭제를 시도할 때 발생하는 예외.
 */
public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(Long id) {
        super("해당 게시글을 찾을 수 없습니다. id=" + id);
    }
}
