package com.example.PostPractice.controller;

import com.example.PostPractice.dto.request.PostCreateRequest;
import com.example.PostPractice.dto.request.PostUpdateRequest;
import com.example.PostPractice.dto.response.PostResponse;
import com.example.PostPractice.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "게시글 API", description = "게시글 CRUD 기능")
public class PostRestController {

    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @Operation(summary = "게시글 생성", description = "새 게시글을 등록합니다")
    public PostResponse create(@RequestBody PostCreateRequest postDto) {
        return postService.create(postDto);
    }

    @GetMapping
    @Operation(summary = "게시글 전체 조회", description = "모든 게시글을 조회합니다")
    public List<PostResponse> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "게시글 상세 조회", description = "특정 게시글을 id를 통해 조회합니다")
    public PostResponse findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "게시글 수정", description = "게시글을 수정합니다")
    public PostResponse update(@PathVariable Long id, @RequestBody PostUpdateRequest postDto) {
        return postService.update(id, postDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}
