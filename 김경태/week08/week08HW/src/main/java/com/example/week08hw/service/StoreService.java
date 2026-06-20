package com.example.week08hw.service;

import com.example.week08hw.dto.request.StoreRequestDto;
import com.example.week08hw.dto.response.StoreResponseDto;
import com.example.week08hw.entity.Store;
import com.example.week08hw.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public StoreResponseDto create(StoreRequestDto request) {
        Store store = storeRepository.save(
                request.name()
        );
        return StoreResponseDto.from(store);
    }

    public List<StoreResponseDto> findAll() {
        return storeRepository.findAll()
                .stream()
                .map(StoreResponseDto::from)
                .toList();
    }

    public void delete(Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 편의점입니다."));

        storeRepository.delete(store);
    }
}
