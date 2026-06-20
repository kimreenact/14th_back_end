package com.likeLion.LikeLion_SpringBoot_Assignment.Controller;

import com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Request.NoticeBoardUpdateDTO;
import com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Request.NoticeBoardCreateDTO;
import com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Response.NoticeBoardResponseDTO;
import com.likeLion.LikeLion_SpringBoot_Assignment.Domain.Post;
import com.likeLion.LikeLion_SpringBoot_Assignment.Service.NoticeBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag( name = "게시판", description = "게시판 API")
@RestController
@RequestMapping("/noticeboard")
public class NoticeboardController {
    private final NoticeBoardService noticeBoardService;

    public NoticeboardController(NoticeBoardService noticeBoardService) {
        this.noticeBoardService = noticeBoardService;
    }

    @Operation(summary = "게시물 등록", description = "새로운 게시물을 등록합니다.")
    @PostMapping()
    public NoticeBoardResponseDTO save(@RequestBody NoticeBoardCreateDTO noticeBoardCreateDTO) {
        return noticeBoardService.save(noticeBoardCreateDTO);
    }

    @Operation(summary = "모든 게시물 조회", description = "등록되어 있는 모든 게시물을 조회합니다.")
    @GetMapping()
    public List<NoticeBoardResponseDTO> findAll() {
        return noticeBoardService.findAll();
    }

    @Operation(summary = "특정 게시물 조회", description = "특정 게시물의 세부 내용을 가져옵니다.")
    @GetMapping("/{id}")
    public NoticeBoardResponseDTO findById(@PathVariable Long id) {
        return noticeBoardService.findById(id);
    }

    @Operation(summary = "게시물 수정", description = "게시물의 내용을 수정합니다.")
    @PatchMapping("/{id}")
    public Post update(@PathVariable Long id, @RequestBody NoticeBoardUpdateDTO noticeBoardUpdateDTO) {
        return noticeBoardService.update(id, noticeBoardUpdateDTO);
    }

    @Operation(summary = "게시물 삭제", description = "id를 통해 특정 게시물 삭제")
    @DeleteMapping("/{id}")
    public Map<String, String> deleteById(@PathVariable Long id) {
        noticeBoardService.deleteById(id);
        return Map.of("message", "게시글이 삭제되었습니다.");
    }
}