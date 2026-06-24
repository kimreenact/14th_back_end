package com.example.week9.Service;

import com.example.week9.domain.Car;
import com.example.week9.Repository.CarRepository;
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

    public List<Car> findAvailable() {
        return carRepository.findBySold(false);
    }

    public String markAsSold(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isEmpty()) {
            return "해당 id의 차량이 존재하지 않습니다";
        }

        Car car = optionalCar.get();

        if (car.isSold()) {
            return "이미 판매된 차량입니다";
        }

        car.setSold(true);
        carRepository.save(car);
        return "판매 완료 처리되었습니다";
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}