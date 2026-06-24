package com.example.posts.controller;

import com.example.posts.dto.PostRequest;
import com.example.posts.dto.PostResponse;
import com.example.posts.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "게시글 API", description = "게시글을 관리하는 API")
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(summary = "게시글 등록", description = "제목, 내용, 작성자를 입력하여 게시글을 등록합니다.")
    @PostMapping
    public PostResponse create(@RequestBody PostRequest request) {
        return postService.create(request);
    }

    @Operation(summary = "게시글 전체 조회", description = "등록된 모든 게시글을 조회합니다.")
    @GetMapping
    public List<PostResponse> findAll() {
        return postService.findAll();
    }

    @Operation(summary = "게시글 상세 조회", description = "id를 이용하여 특정 게시글을 조회합니다.")
    @GetMapping("/{id}")
    public PostResponse findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @Operation(summary = "게시글 수정", description = "id에 해당하는 게시글을 수정합니다.")
    @PatchMapping("/{id}")
    public PostResponse update(
            @PathVariable Long id,
            @RequestBody PostRequest request
    ) {
        return postService.update(id, request);
    }

    @Operation(summary = "게시글 삭제", description = "id에 해당하는 게시글을 삭제합니다.")
    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        postService.delete(id);
        return Map.of("message", "게시글이 삭제되었습니다.");
    }
}
