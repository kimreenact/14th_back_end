package com.example.week09hw.controller;

import com.example.week09hw.dto.request.RequestDto;
import com.example.week09hw.dto.response.ResponseDto;
import com.example.week09hw.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
@Tag(name = "Car API", description = "차량 관리 API")
public class CarController {

    private final CarService carService;

    @Operation(summary = "차량 등록")
    @PostMapping
    public ResponseDto save(@RequestBody RequestDto dto) {
        return carService.save(dto);
    }

    @Operation(summary = "전체 차량 조회")
    @GetMapping
    public List<ResponseDto> findAll() {
        return carService.findAll();
    }

    @Operation(summary = "브랜드로 차량 검색")
    @GetMapping("/search")
    public List<ResponseDto> findByBrand(
            @RequestParam String brand) {

        return carService.findByBrand(brand);
    }

    @Operation(summary = "판매되지 않은 차량 조회")
    @GetMapping("/available")
    public List<ResponseDto> findUnsoldCars() {
        return carService.findUnsoldCars();
    }

    @Operation(summary = "차량 판매 완료 처리")
    @PutMapping("/{id}/sold")
    public ResponseDto setSold(
            @PathVariable Long id) {

        return carService.setSold(id);
    }

    @Operation(summary = "차량 삭제")
    @DeleteMapping("/{id}")
    public void deleteCar(
            @PathVariable Long id) {

        carService.deleteCar(id);
    }
}