package com.example.PostPractice.repository;

import com.example.PostPractice.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepository {
    private final Map<Long, Post> postMap = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public Post save(Post post) {
        Long newId = sequence.incrementAndGet();
        Post savedPost = new Post(newId, post.getTitle(), post.getAuthor(), post.getContent());
        postMap.put(newId, savedPost);
        return savedPost;
    }

    public List<Post> findAll() {
        return new ArrayList<>(postMap.values());
    }

    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(postMap.get(id));
    }

    public void deleteById(Long id) {
        postMap.remove(id);
    }
}
