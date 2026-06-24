package com.example.posts.service;

import com.example.posts.domain.Post;
import com.example.posts.dto.PostRequest;
import com.example.posts.dto.PostResponse;
import com.example.posts.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public PostResponse create(PostRequest request) {
        Post post = postRepository.save(
                request.title(),
                request.content(),
                request.author()
        );
        return PostResponse.from(post);
    }

    public List<PostResponse> findAll() {
        return postRepository.findAll()
                .stream()
                .map(PostResponse::from)
                .toList();
    }

    public PostResponse findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        return PostResponse.from(post);
    }

    public PostResponse update(Long id, PostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        post.update(
                request.title(),
                request.content(),
                request.author()
        );
        return PostResponse.from(post);
    }

    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        postRepository.delete(post);
    }
}