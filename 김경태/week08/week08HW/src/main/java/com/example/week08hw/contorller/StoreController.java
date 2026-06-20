package com.example.week08hw.contorller;

import com.example.week08hw.dto.request.StoreRequestDto;
import com.example.week08hw.dto.response.StoreResponseDto;
import com.example.week08hw.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Store API", description = "편의점 목록 관리")
@RestController
@RequestMapping("/api/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @Operation(summary = "전체 편의점 조회")
    @GetMapping
    public List<StoreResponseDto> findAll() {
        return storeService.findAll();
    }

    @Operation(summary = "편의점 등록")
    @PostMapping("/add")
    public StoreResponseDto create(
            @RequestBody StoreRequestDto request
    ) {
        return storeService.create(request);
    }

    @Operation(summary = "편의점 삭제")
    @DeleteMapping("/{storeId}")
    public void delete(
            @PathVariable Long storeId
    ) {
        storeService.delete(storeId);
    }
}