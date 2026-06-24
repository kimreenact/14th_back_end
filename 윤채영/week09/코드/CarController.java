package com.example.hw9.controller;

import com.example.hw9.domain.Car;
import com.example.hw9.service.CarService;
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
    public Car register(@RequestBody Car car){
        return service.register(car);
    }
    @GetMapping
    public List<Car> getAll(){
        return service.getAll();
    }
    @GetMapping("/search")
    public List<Car> findByBrand(@RequestParam String brand){
        return  service.searchByBrand(brand);
    }

    @GetMapping("/available")
    public List<Car> getAvailable() {
        return service.getAvailable();
    }

    @PutMapping("/{id}/sold")
    public String save(@PathVariable Long id){
        return service.markAsSold(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


}
