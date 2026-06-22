package com.example.hw9.service;

import com.example.hw9.domain.Car;
import com.example.hw9.repository.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CarService {
    private final CarRepository repository;

    public CarService(CarRepository repository){
        this.repository = repository;
    }
    public Car register(Car car){
        return  repository.save(car);
    }
    public List<Car> getAll(){
        return repository.findAll();
    }
    public List<Car> searchByBrand(String brand){
        return repository.findByBrand(brand);
    }

    public List<Car> getAvailable() {
        return repository.findBySoldFalse();
    }

    public String markAsSold(Long id){
        Car car = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("차량을 찾을 수 없습니다."));
        if (car.isSold()){
            return "이미 판매된 차량입니다.";
        }
        car.setSold(true);
        repository.save(car);
        return "판매 완료 처리되었습니다.";
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
