package com.example.post.controller;

import com.example.post.dto.PostCreateRequest;
import com.example.post.dto.PostResponse;
import com.example.post.dto.PostUpdateRequest;
import com.example.post.exception.ErrorResponse;
import com.example.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시글 관리 REST API 컨트롤러
 *
 * @Tag : Swagger UI 에서 API 그룹 이름/설명을 지정한다.
 */
@Tag(name = "게시글 관리 API", description = "게시글 생성/조회/수정/삭제를 위한 CRUD API")
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /** 게시글 생성. POST /api/posts */
    @Operation(summary = "게시글 생성", description = "새로운 게시글을 생성한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "생성 성공"),
            @ApiResponse(responseCode = "400", description = "입력값 검증 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping
    public ResponseEntity<PostResponse> create(@Valid @RequestBody PostCreateRequest request) {
        PostResponse response = postService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /** 게시글 전체 조회. GET /api/posts?keyword= */
    @Operation(summary = "게시글 전체 조회",
            description = "전체 게시글을 조회한다. keyword 쿼리 파라미터로 제목 검색이 가능하다.")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll(
            @Parameter(description = "제목 검색 키워드 (선택)", example = "게시글")
            @RequestParam(required = false) String keyword) {
        return ResponseEntity.ok(postService.findAll(keyword));
    }

    /** 게시글 상세 조회. GET /api/posts/{id} */
    @Operation(summary = "게시글 상세 조회", description = "id로 게시글 1건을 조회한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "게시글 없음",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findById(
            @Parameter(description = "게시글 ID", example = "1")
            @PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    /** 게시글 수정. PATCH /api/posts/{id} */
    @Operation(summary = "게시글 수정", description = "id로 게시글을 부분 수정한다. (제목/내용)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "수정 성공"),
            @ApiResponse(responseCode = "404", description = "게시글 없음",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PatchMapping("/{id}")
    public ResponseEntity<PostResponse> update(
            @Parameter(description = "게시글 ID", example = "1")
            @PathVariable Long id,
            @RequestBody PostUpdateRequest request) {
        return ResponseEntity.ok(postService.update(id, request));
    }

    /** 게시글 삭제. DELETE /api/posts/{id} */
    @Operation(summary = "게시글 삭제", description = "id로 게시글을 삭제한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "삭제 성공"),
            @ApiResponse(responseCode = "404", description = "게시글 없음",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "게시글 ID", example = "1")
            @PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
