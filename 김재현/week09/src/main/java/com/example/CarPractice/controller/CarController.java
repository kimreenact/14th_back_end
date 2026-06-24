package com.example.CarPractice.controller;

import com.example.CarPractice.domain.Car;
import com.example.CarPractice.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@Tag(name = "Car", description = "자동차 판매 플랫폼 API")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    @Operation(summary = "차량 등록", description = "새 차량을 등록한다. id는 서버가 자동 생성하므로 보내지 않는다.")
    public Car save(@RequestBody Car car) {
        return carService.save(car);
    }

    @GetMapping
    @Operation(summary = "전체 차량 조회", description = "등록된 모든 차량을 조회한다.")
    public List<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping("/search")
    @Operation(summary = "브랜드로 차량 검색", description = "brand 값과 정확히 일치하는 차량을 조회한다.")
    public List<Car> findByBrand(
            @Parameter(description = "검색할 브랜드명", example = "현대")
            @RequestParam String brand) {
        return carService.findByBrand(brand);
    }

    @GetMapping("/available")
    @Operation(summary = "판매 가능 차량 조회", description = "아직 판매되지 않은(sold=false) 차량만 조회한다.")
    public List<Car> findBySoldFalse() {
        return carService.findBySoldFalse();
    }

    @PutMapping("/{id}/sold")
    @Operation(summary = "차량 판매 완료 처리", description = "해당 차량의 sold를 true로 변경한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "판매 완료 처리 성공"),
            @ApiResponse(responseCode = "404", description = "차량을 찾을 수 없음"),
            @ApiResponse(responseCode = "409", description = "이미 판매된 차량")
    })
    public Car markAsSold(
            @Parameter(description = "판매 처리할 차량 ID", example = "1")
            @PathVariable Long id) {
        return carService.markAsSold(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "차량 삭제", description = "해당 ID의 차량을 삭제한다.")
    public void delete(
            @Parameter(description = "삭제할 차량 ID", example = "1")
            @PathVariable Long id) {
        carService.delete(id);
    }
}
