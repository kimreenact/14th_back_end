package com.example.week09hw.repository;

import com.example.week09hw.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);

    List<Car> findBySoldFalse();
}
