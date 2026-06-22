package com.likeLion.LikeLion_SpringBoot_Assignment.Service;

import com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Request.CarRequestDTO;
import com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Response.CarResponseDTO;
import com.likeLion.LikeLion_SpringBoot_Assignment.Domain.Car;
import com.likeLion.LikeLion_SpringBoot_Assignment.Repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarResponseDTO saveCar(CarRequestDTO carRequestDTO) {
        Car savedCar = this.carRepository.save(carRequestDTO.toEntity());
        return CarResponseDTO.from(savedCar);
    }

    public List<CarResponseDTO> findAll() {
        return this.carRepository.findAll().stream().map(CarResponseDTO::from).toList();
    }

    public List<CarResponseDTO> findByBrand(String brand) {
        List<Car> searchCar = this.carRepository.findByBrand(brand);
        if(searchCar.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 자동차입니다.");
        }
        return searchCar.stream().map(CarResponseDTO::from).toList();
    }

    public List<CarResponseDTO> findByIsSold() {
        return this.carRepository.findByIsSold(false).stream().map(CarResponseDTO::from).toList();
    }

    public CarResponseDTO updateCar(Long id) {
        Car car = this.carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 자동차입니다."));
        if(car.isSold()) {
            throw new IllegalArgumentException("이미 팔린 차량입니다.");
        }
        car.update();
        return CarResponseDTO.from(car);
    }

    public void deleteCar(Long id) {
        Car car = this.carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 자동차입니다."));
        this.carRepository.delete(car);
    }
}
