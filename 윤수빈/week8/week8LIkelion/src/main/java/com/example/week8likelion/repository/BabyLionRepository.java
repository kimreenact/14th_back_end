package com.example.week8likelion.repository;

import com.example.week8likelion.domain.BabyLion;
import com.example.week8likelion.dto.BabyLionCreateRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BabyLionRepository {
    private final List<BabyLion> babyLions = new ArrayList<>();
    private Long sequence = 1L;

    public BabyLion save(String name, int age, String part) {
        BabyLion babyLion = new BabyLion(sequence++, name, age, part);

        babyLions.add(babyLion);
        return babyLion;
    }

    public List<BabyLion> findAll() {
        return babyLions;
    }

    public Optional<BabyLion> findById(Long id) {
        return babyLions.stream().filter(babyLion -> babyLion.getId().equals(id)).findFirst();

    }

    public void delete(BabyLion babyLion) {
        babyLions.remove(babyLion);
    }

}
