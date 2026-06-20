package com.example.week08hw.contorller;

import com.example.week08hw.dto.request.StockPatchDto;
import com.example.week08hw.dto.request.StockRequestDto;
import com.example.week08hw.dto.response.ProductResponseDto;
import com.example.week08hw.dto.response.StockResponseDto;
import com.example.week08hw.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Stock API", description = "편의점 재고 관리")
@RestController
@RequestMapping("/api/store/{storeId}/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @Operation(summary = "편의점 전체 재고 조회")
    @GetMapping
    public List<ProductResponseDto> findAll(
            @PathVariable Long storeId
    ) {
        return stockService.findAllProduct(storeId);
    }

    @Operation(summary = "특정 상품 조회")
    @GetMapping("/{productId}")
    public StockResponseDto findOne(
            @PathVariable Long storeId,
            @PathVariable Long productId
    ) {
        return stockService.getProduct(storeId, productId);
    }

    @Operation(summary = "상품 등록")
    @PostMapping("/add")
    public StockResponseDto create(
            @PathVariable Long storeId,
            @RequestBody StockRequestDto request
    ) {
        return stockService.createProduct(storeId, request);
    }

    @Operation(summary = "재고 수량 수정")
    @PatchMapping("/{productId}")
    public StockResponseDto patch(
            @PathVariable Long storeId,
            @PathVariable Long productId,
            @RequestBody StockPatchDto request
    ) {
        return stockService.patchQuantity(
                storeId,
                productId,
                request
        );
    }

    @Operation(summary = "상품 전체 수정")
    @PutMapping("/{productId}")
    public StockResponseDto update(
            @PathVariable Long storeId,
            @PathVariable Long productId,
            @RequestBody StockRequestDto request
    ) {
        return stockService.updateProduct(
                storeId,
                productId,
                request
        );
    }
}