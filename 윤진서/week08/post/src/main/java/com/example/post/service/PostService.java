package com.example.post.service;

import com.example.post.domain.Post;
import com.example.post.dto.PostCreateRequest;
import com.example.post.dto.PostResponse;
import com.example.post.dto.PostUpdateRequest;
import com.example.post.exception.PostNotFoundException;
import com.example.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 게시글 비즈니스 로직 (Service 계층).
 * Controller 와 Repository 사이에서 도메인 ↔ DTO 변환 및 핵심 로직을 담당한다.
 */
@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /** 게시글 생성 */
    public PostResponse create(PostCreateRequest request) {
        Post post = new Post(request.title(), request.content(), request.author());
        Post saved = postRepository.save(post);
        return PostResponse.from(saved);
    }

    /** 게시글 전체 조회 (keyword 로 제목 검색 가능 — Query Parameter 활용) */
    public List<PostResponse> findAll(String keyword) {
        return postRepository.findAll().stream()
                .filter(post -> keyword == null || keyword.isBlank()
                        || post.getTitle().contains(keyword))
                .map(PostResponse::from)
                .toList();
    }

    /** 게시글 상세 조회 (없으면 예외 — Path Variable 활용) */
    public PostResponse findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        return PostResponse.from(post);
    }

    /** 게시글 부분 수정 (없으면 예외, null 이 아닌 필드만 반영) */
    public PostResponse update(Long id, PostUpdateRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        if (request.title() != null) {
            post.setTitle(request.title());
        }
        if (request.content() != null) {
            post.setContent(request.content());
        }
        post.setUpdatedAt(LocalDateTime.now());

        Post saved = postRepository.save(post);
        return PostResponse.from(saved);
    }

    /** 게시글 삭제 (없으면 예외) */
    public void delete(Long id) {
        if (!postRepository.existsById(id)) {
            throw new PostNotFoundException(id);
        }
        postRepository.deleteById(id);
    }
}
