package com.example.car_market;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrand(String brand); // 브랜드로 차량 검색

    List<Car> findBySoldFalse(); // 판매되지 않은 차량만 조회
}
