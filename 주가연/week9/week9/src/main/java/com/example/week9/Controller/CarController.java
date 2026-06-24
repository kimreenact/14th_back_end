package com.example.week9.Controller;

import com.example.week9.domain.Car;
import com.example.week9.Service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.save(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/search")
    public List<Car> searchByBrand(@RequestParam String brand) {
        return carService.findByBrand(brand);
    }

    @GetMapping("/available")
    public List<Car> getAvailableCars() {
        return carService.findAvailable();
    }

    @PutMapping("/{id}/sold")
    public String markAsSold(@PathVariable Long id) {
        return carService.markAsSold(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.delete(id);
    }
}
