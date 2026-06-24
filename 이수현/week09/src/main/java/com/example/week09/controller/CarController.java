package com.example.week09.controller;

import com.example.week09.Car;
import com.example.week09.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/cars")
public class CarController {
    private final CarService service;
    public CarController(CarService service){
        this.service = service;
    }

    @PostMapping
    public Car creatCar(@RequestBody Car car){
        return service.createCar(car);
    }

    @GetMapping
    public List<Car> findAll(){
        return service.findAll();
    }
    @GetMapping("/search")
    public List<Car> searchByBrand(@RequestParam String brand){
        return  service.searchByBrand(brand);
    }
    @GetMapping("/available")
    public List<Car> getAvailable(){
        return service.getAvailableCars();
    }

    @PutMapping("/{id}/sold")
    public String sellCar(@PathVariable Long id){
        return  service.sellCar(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
