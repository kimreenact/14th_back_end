package com.example.week8likelion.service;

import com.example.week8likelion.domain.BabyLion;
import com.example.week8likelion.dto.BabyLionCreateRequest;
import com.example.week8likelion.dto.BabyLionResponse;
import com.example.week8likelion.dto.BabyLionUpdateRequest;
import com.example.week8likelion.repository.BabyLionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BabyLionService {

    private final BabyLionRepository babyLionRepository;

    public BabyLionService(BabyLionRepository babyLionRepository) {
        this.babyLionRepository = babyLionRepository;
    }

    public BabyLionResponse create(BabyLionCreateRequest request) {
        BabyLion babyLion = babyLionRepository.save(
                request.name(),
                request.age(),
                request.part()
        );

        return BabyLionResponse.from(babyLion);
    }

    public List<BabyLionResponse> findAll() {
        return babyLionRepository.findAll()
                .stream()
                .map(BabyLionResponse::from)
                .toList();
    }

    public BabyLionResponse findById(Long id) {
        BabyLion babyLion = babyLionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아기 사자입니다."));

        return BabyLionResponse.from(babyLion);
    }

    public BabyLionResponse update(Long id, BabyLionUpdateRequest request) {

        BabyLion babyLion = babyLionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아기 사자입니다."));

        babyLion.update(
                request.name(),
                request.age(),
                request.part()
        );
        return BabyLionResponse.from(babyLion);
    }

    public void delete(Long id) {
        BabyLion babyLion = babyLionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아기사자입니다."));

        babyLionRepository.delete(babyLion);
    }
}
