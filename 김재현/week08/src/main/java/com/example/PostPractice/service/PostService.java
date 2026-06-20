package com.example.PostPractice.service;

import com.example.PostPractice.domain.Post;
import com.example.PostPractice.dto.request.PostCreateRequest;
import com.example.PostPractice.dto.request.PostUpdateRequest;
import com.example.PostPractice.dto.response.PostResponse;
import com.example.PostPractice.exception.PostNotFoundException;
import com.example.PostPractice.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponse create(PostCreateRequest postDto) {
        Post saved = postRepository.save(new Post(null, postDto.getTitle(), postDto.getAuthor(), postDto.getContent()));
        return new PostResponse(saved.getId(), saved.getTitle(), saved.getAuthor(), saved.getContent());
    }

    public List<PostResponse> findAll() {
        List<Post> posts = postRepository.findAll();
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            postResponses.add(new PostResponse(post.getId(), post.getTitle(), post.getAuthor(), post.getContent()));
        }
        return postResponses;
    }

    public PostResponse findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        return new PostResponse(post.getId(), post.getTitle(), post.getAuthor(), post.getContent());
    }

    public PostResponse update(Long id, PostUpdateRequest request) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));

        String newTitle = request.getTitle() != null ? request.getTitle() : post.getTitle();
        String newAuthor = request.getAuthor() != null ? request.getAuthor() : post.getAuthor();
        String newContent = request.getContent() != null ? request.getContent() : post.getContent();

        post.update(newTitle, newAuthor, newContent);

        return new PostResponse(post.getId(), post.getTitle(), post.getAuthor(), post.getContent());
    }

    public void delete(Long id) {
        postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        postRepository.deleteById(id);
    }
}
