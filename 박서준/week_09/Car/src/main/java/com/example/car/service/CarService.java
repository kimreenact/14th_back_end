package com.example.car.service;

import com.example.car.domain.Car;
import com.example.car.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    //차량등록
    public Car save(Car car) {
        return carRepository.save(car);
    }

    //전체 차량 조회
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    //브랜드로 차량 검색
    public List<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }
    //판매되지 않은 차량만 조회
    public List<Car> findAvailable() {
        return carRepository.findBySoldFalse();
    }
    //차량을 판매 완료 처리
    public Car sell(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 차량입니다."));

        if (car.isSold()) {
            throw new IllegalArgumentException("이미 판매된 차량입니다.");
        }

        car.setSold(true);
        return carRepository.save(car);
    }
    //차량 삭제
    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
