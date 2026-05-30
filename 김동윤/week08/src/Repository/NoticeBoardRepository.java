package com.likeLion.LikeLion_SpringBoot_Assignment.Repository;

import com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Request.NoticeBoardCreateDTO;
import com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Request.NoticeBoardUpdateDTO;
import com.likeLion.LikeLion_SpringBoot_Assignment.Domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NoticeBoardRepository {
    List<Post> posts = new ArrayList<>();
    private Long sequece = 1L;

    public Post save(NoticeBoardCreateDTO noticeBoardCreateDTO) {
        Post post = new Post(sequece++, noticeBoardCreateDTO.title(), noticeBoardCreateDTO.content(), noticeBoardCreateDTO.author());
        posts.add(post);
        return post;
    }

    public List<Post> findAll() {
        return posts;
    }

    public Optional<Post> findById(Long id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst();
    }

    public Post update(Long id, NoticeBoardUpdateDTO noticeBoardUpdateDTO) {
        Post post = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다. id=" + id));
        post.setTitle(noticeBoardUpdateDTO.title());
        post.setContent(noticeBoardUpdateDTO.content());
        post.setAuthor(noticeBoardUpdateDTO.author());
        return post;
    }

    public void deleteById(Long id) {
        findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다. id=" + id));
        posts.removeIf(post -> post.getId().equals(id));
    }
}