package com.example.car_market;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    // 차량 등록
    @PostMapping
    public Car save(@RequestBody Car car) {
        return service.save(car);
    }

    // 전체 차량 조회
    @GetMapping
    public List<Car> findAll() {
        return service.findAll();
    }

    // 브랜드로 차량 검색
    @GetMapping("/search")
    public List<Car> findByBrand(@RequestParam String brand) {
        return service.findByBrand(brand);
    }

    // 판매되지 않은 차량만 조회
    @GetMapping("/available")
    public List<Car> findAvailable() {
        return service.findAvailable();
    }

    // 차량을 판매 완료 처리
    @PutMapping("/{id}/sold")
    public ResponseEntity<?> markAsSold(@PathVariable Long id) {
        try {
            Car car = service.markAsSold(id);
            return ResponseEntity.ok(car);
        } catch (IllegalStateException e) {
            // 이미 판매된 차량인 경우
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // 차량 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
