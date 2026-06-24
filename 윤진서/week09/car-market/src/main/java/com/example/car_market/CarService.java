package com.example.car_market;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CarService {

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    // 차량 등록
    public Car save(Car car) {
        car.setId(null);
        return repository.save(car);
    }

    // 전체 차량 조회
    public List<Car> findAll() {
        return repository.findAll();
    }

    // 브랜드로 차량 검색
    public List<Car> findByBrand(String brand) {
        return repository.findByBrand(brand);
    }

    // 판매되지 않은 차량만 조회
    public List<Car> findAvailable() {
        return repository.findBySoldFalse();
    }

    // 판매 완료 처리
    public Car markAsSold(Long id) {
        Car car = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 차량을 찾을 수 없습니다"));

        if (car.isSold()) {
            throw new IllegalStateException("이미 판매된 차량입니다");
        }

        car.setSold(true);
        return repository.save(car);
    }

    // 차량 삭제
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
