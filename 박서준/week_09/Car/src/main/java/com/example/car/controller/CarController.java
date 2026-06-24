package com.example.car.controller;

import com.example.car.domain.Car;
import com.example.car.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    // 차량 등록
    @PostMapping
    public Car save(@RequestBody Car car) {
        return carService.save(car);
    }

    // 전체 조회
    @GetMapping
    public List<Car> findAll() {
        return carService.findAll();
    }

    // 브랜드 검색
    @GetMapping("/search")
    public List<Car> findByBrand(@RequestParam String brand) {
        return carService.findByBrand(brand);
    }

    // 판매 안 된 차량
    @GetMapping("/available")
    public List<Car> findAvailable() {
        return carService.findAvailable();
    }
    // 판매 완료 처리
    @PutMapping("/{id}/sold")
    public Car sell(@PathVariable Long id) {
        return carService.sell(id);
    }
    // 차량 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }
}
