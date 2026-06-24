package com.example.CarPractice.service;

import com.example.CarPractice.domain.Car;
import com.example.CarPractice.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public List<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public List<Car> findBySoldFalse() {
        return carRepository.findBySoldFalse();
    }

    public Car markAsSold(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("차량을 찾을 수 없습니다"));
        if (car.isSold()) {
            throw new IllegalStateException("이미 판매된 차량입니다");
        }
        car.setSold(true);
        return carRepository.save(car);
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
