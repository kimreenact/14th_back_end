package com.example.week8likelion.controller;

import com.example.week8likelion.dto.BabyLionCreateRequest;
import com.example.week8likelion.dto.BabyLionResponse;
import com.example.week8likelion.dto.BabyLionUpdateRequest;
import com.example.week8likelion.service.BabyLionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "BabyLion API", description = "아기 사자 정보를 관리하는 API")
@RestController
@RequestMapping("/api/baby-lions")

public class BabyLionController {
    private final BabyLionService babyLionService;

    public BabyLionController(BabyLionService babyLionService) {
        this.babyLionService = babyLionService;
    }

    @Operation(summary = "아기 사자 등록", description = "이름, 나이, 파트를 입력하여 아기 사자를 등록합니다.")
    @PostMapping
    public BabyLionResponse create(@RequestBody BabyLionCreateRequest request) {
        return babyLionService.create(request);
    }

    @Operation(summary = "아기 사자 전체 조회", description = "등록된 모든 아기 사자 정보를 조회합니다.")
    @GetMapping
    public List<BabyLionResponse> findAll() {
        return babyLionService.findAll();
    }

    @Operation(summary = "아기 사자 상세 조회", description = "id를 이용하여 특정 아기 사자 정보를 조회합니다.")
    @GetMapping("/{id}")
    public BabyLionResponse findById(@PathVariable Long id) {
        return babyLionService.findById(id);
    }

    @Operation(summary = "아기 사자 정보 수정", description = "id에 해당하는 아기 사자의 정보를 수정합니다.")
    @PatchMapping("/{id}")
    public BabyLionResponse update(
            @PathVariable Long id,
            @RequestBody BabyLionUpdateRequest request
    ) {
        return babyLionService.update(id, request);
    }

    @Operation(summary = "아기 사자 삭제", description = "id에 해당하는 아기 사자 정보를 삭제합니다.")
    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        babyLionService.delete(id);

        return Map.of("message", "아기 사자 정보가 삭제되었습니다.");
    }
}
