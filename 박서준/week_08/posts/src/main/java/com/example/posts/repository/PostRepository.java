package com.example.posts.repository;
import org.springframework.stereotype.Repository;
import com.example.posts.domain.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    private final List<Post> posts = new ArrayList<>();
    private Long sequence = 1L;

    public Post save(String title, String content, String author) {
        Post post = new Post(sequence++, title, content, author);
        posts.add(post);
        return post;
    }

    public List<Post> findAll() {
        return posts;
    }

    public Optional<Post> findById(Long id) {
        return posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst();
    }

    public void delete(Post post) {
        posts.remove(post);
    }
}
