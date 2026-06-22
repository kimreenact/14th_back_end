package com.likeLion.LikeLion_SpringBoot_Assignment.Repository;

import com.likeLion.LikeLion_SpringBoot_Assignment.Domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByIsSold(boolean isSold);
}
