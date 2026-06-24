package com.example.car.repository;

import com.example.car.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String Brand);
    List<Car> findBySoldFalse();
}
