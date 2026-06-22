package com.example.week09.service;

import com.example.week09.Car;
import com.example.week09.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CarService {
    private final CarRepository repository;

    public CarService(CarRepository repository){
        this.repository = repository;
    }
    public Car createCar(Car car){
        return repository.save(car);
    }


    public List<Car> findAll(){
        return repository.findAll();
    }

    public List<Car> searchByBrand(String brand){
        return repository.findByBrand(brand);
    }

    public List<Car> getAvailableCars(){
        return repository.findBySoldFalse();
    }

    public String sellCar(Long id){
        Optional<Car> carOptional = repository.findById(id);
        if (carOptional.isEmpty()) {
            return "차량을 찾을 수 없습니다.";
        }
        Car car = carOptional.get();
        if (car.isSold()){
            return "이미 판매된 차량입니다.";
        }
        car.setSold(true);
        repository.save(car);
        return "판매완료";
        }


    public void delete (Long id){
        repository.deleteById(id);
    }
}
