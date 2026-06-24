package com.example.week09hw.service;

import com.example.week09hw.dto.request.RequestDto;
import com.example.week09hw.dto.response.ResponseDto;
import com.example.week09hw.entity.Car;
import com.example.week09hw.repository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public ResponseDto save(RequestDto dto) {
        Car car = new Car();

        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setPrice(dto.getPrice());
        car.setSold(false);

        Car saved = carRepository.save(car);

        return ResponseDto.from(saved);
    }

    public List<ResponseDto> findAll() {

        return carRepository.findAll()
                .stream()
                .map(ResponseDto::from)
                .toList();
    }

    public List<ResponseDto> findByBrand(String brand) {

        return carRepository.findByBrand(brand)
                .stream()
                .map(ResponseDto::from)
                .toList();
    }

    public List<ResponseDto> findUnsoldCars() {

        return carRepository.findBySoldFalse()
                .stream()
                .map(ResponseDto::from)
                .toList();
    }

    public ResponseDto setSold(Long id){
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 차량입니다."));

        car.setSold(true);

        return ResponseDto.from(car);
    }

    public void deleteCar(Long id){
        carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 차량입니다."));

        carRepository.deleteById(id);
    }
}
