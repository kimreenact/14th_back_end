package com.likeLion.LikeLion_SpringBoot_Assignment.Controller;

import com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Request.CarRequestDTO;
import com.likeLion.LikeLion_SpringBoot_Assignment.DTO.Response.CarResponseDTO;
import com.likeLion.LikeLion_SpringBoot_Assignment.Service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "자동차 목록 관리", description = "자동차 목록 관리 API")
@RestController
@RequestMapping("/cars")
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Operation(summary = "차량 등록", description = "새로운 차량을 등록합니다.")
    @PostMapping()
    public CarResponseDTO saveCar(@RequestBody CarRequestDTO carRequestDTO) {
        return this.carService.saveCar(carRequestDTO);
    }

    @Operation(summary = "모든 챠량 조회", description = "등록되어있는 모든 차량 목록 조회")
    @GetMapping()
    public List<CarResponseDTO> findAll() {
        return this.carService.findAll();
    }

    @Operation(summary = "특정 브랜드 조회", description = "특정 브랜드명을 가진 모든 차량 조회")
    @GetMapping("/search")
    public List<CarResponseDTO> findByBrand(@RequestParam String brand) {
        return this.carService.findByBrand(brand);
    }

    @Operation(summary = "미판매 차량 조회", description = "판매되지 않은 모든 차량 조회")
    @GetMapping("/available")
    public List<CarResponseDTO> findByIsSold() {
        return this.carService.findByIsSold();
    }

    @Operation(summary = "차량 판매 등록", description = "등록되어 있는 차량을 판매한 차량으로 표기")
    @PutMapping("/{id}/sold")
    public CarResponseDTO updateCar(@PathVariable Long id) {
        return this.carService.updateCar(id);
    }

    @Operation(summary = "차량 삭제", description = "등록되어 있는 차량 중 특정 차량 삭제")
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        this.carService.deleteCar(id);
    }
}
