package com.example.postapi.service;

import com.example.postapi.domain.Post;
import com.example.postapi.dto.PostCreateRequest;
import com.example.postapi.dto.PostResponse;
import com.example.postapi.dto.PostUpdateRequest;
import com.example.postapi.exception.PostNotFoundException;
import com.example.postapi.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponse create(PostCreateRequest request) {
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
                .orElseThrow(() -> new PostNotFoundException(id));

        return PostResponse.from(post);
    }

    public PostResponse update(Long id, PostUpdateRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        post.update(
                request.title(),
                request.content(),
                request.author()
        );

        return PostResponse.from(post);
    }

    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        postRepository.delete(post);
    }
}
