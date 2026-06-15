package com.example.owcs.controller;

import com.example.owcs.dto.OwcsCreateRequest;
import com.example.owcs.dto.OwcsResponse;
import com.example.owcs.dto.OwcsUpdateRequest;
import com.example.owcs.service.OwcsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "OWCS API", description = "오버워치 팀 관리 API")
@RestController
@RequestMapping("/api/players")

public class OwcsController {

    private final OwcsService owcsService;
    public OwcsController (OwcsService owcsService){
        this.owcsService = owcsService;
    }

    // 1. 생성 (POST /api/players)
    @Operation(summary = "선수 등록",description = "Input team, nickname, position, heros")
    @PostMapping
    public OwcsResponse create(@RequestBody OwcsCreateRequest request) {
        return owcsService.create(request);
        }

    // 2. 전체 조회 (GET /api/players)
    @Operation(summary = "선수 전체 조회",description = "등록된 모든 선수 정보를 조회합니다.")
    @GetMapping
    public List<OwcsResponse> findAll() {
        return owcsService.findAll();

    }

    @Operation(summary = "선수 상세 조회",description = "id를 이용하여 특정 선수 정보를 조회합니다.")
    @GetMapping("/{id}")
    public OwcsResponse findById(@PathVariable Long id) {
        return owcsService.findById(id);
    }


    @Operation(summary = "선수 정보 수정",description = "id에 해당하는 선수 정보를 수정합니다.")
    @PatchMapping("/{id}")
    public OwcsResponse update(@PathVariable Long id, @RequestBody OwcsUpdateRequest request) {
        return  owcsService.update(id,request);
    }


    @Operation(summary = "선수 삭제")
    @DeleteMapping("/{id}")
    public Map<String,String> delete(@PathVariable Long id) {
        owcsService.delete(id);
        return Map.of("message","선수 정보가 삭제되었습니다.");
    }
}