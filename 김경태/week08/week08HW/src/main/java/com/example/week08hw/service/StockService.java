package com.example.week08hw.service;

import com.example.week08hw.dto.request.StockPatchDto;
import com.example.week08hw.dto.request.StockRequestDto;
import com.example.week08hw.dto.response.ProductResponseDto;
import com.example.week08hw.dto.response.StockResponseDto;
import com.example.week08hw.entity.Stock;
import com.example.week08hw.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public  StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    // 상품 검증
    private Stock getStock(Long storeId, Long productId) {
        Stock stock = stockRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        if (!stock.getStoreId().equals(storeId)) {
            throw new IllegalArgumentException("해당 편의점 상품이 아닙니다.");
        }
        return stock;
    }

    // 전체 상품 목록 반환
    public List<ProductResponseDto> findAllProduct(Long storeId) {
        return stockRepository.findByStoreId(storeId)
                .stream()
                .map(ProductResponseDto::from)
                .toList();
    }

    // 특정 상품 목록 반환
    public StockResponseDto getProduct(Long storeId, Long productId) {
        return StockResponseDto.from(
                getStock(storeId, productId)
        );
    }

    // 상품 추가
    public StockResponseDto createProduct(Long storeId, StockRequestDto request) {
        Stock stock = stockRepository.save(
                storeId,
                request.productName(),
                request.price(),
                request.quantity()
        );
        return StockResponseDto.from(stock);
    }

    // 수량 수정
    public StockResponseDto patchQuantity(Long storeId, Long productId, StockPatchDto request) {
        Stock stock = getStock(storeId, productId);

        stock.setQuantity(request.quantity());

        return StockResponseDto.from(stock);
    }

    // 상품 수정
    public StockResponseDto updateProduct(Long storeId, Long productId, StockRequestDto request) {
        Stock stock =  getStock(storeId, productId);

        stock.setProductName(request.productName());
        stock.setPrice(request.price());
        stock.setQuantity(request.quantity());

        return StockResponseDto.from(stock);
    }
}