package org.example.week9assignment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@RestController를 붙여서 이 클래스가 JSON 형태의 데이터를 반환하는 RESTful API 컨트롤러임을 명시했음
//@RequestMapping("/cars")로 공통 기본 URL 주소를 묶어주어 가독성을 높이고 중복 코드를 줄이는 요령을 익혔음
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    //CarService를 생성자로 주입받아 명령만 내리는 구조
    public CarController(CarService carService) {
        this.carService = carService;
    }


    //차량 등록
    @PostMapping
    public Car registerCar(@RequestBody Car car) {
        return carService.registerCar(car);
    }

    //전체 조회
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }


    //특정 브랜드로 검색할 때 URL 뒤에 [`?brand=현대`-> 쿼리 스트링(Query String)] 방식을 다루기 위해 @RequestParam 사용(쿼리스트링으로 들어온 값 처리하기위해 쿼리매서드 가져다 씀)
    @GetMapping("/search")
    public ResponseEntity<List<Car>> getCarsByBrand(@RequestParam String brand) {
        List<Car> cars = carService.getCarsByBrand(brand);
        return ResponseEntity.ok(cars);
    }

    //판매되지 않은 차량 목록이라는 조건부 조회 -> GET 메서드로 설계, /available이라는 명확한 경로를 부여 -> 가능한 것만 조건부 조회
    @GetMapping("/available")
    public ResponseEntity<List<Car>> getAvailableCars() {
        List<Car> cars = carService.getAvailableCars();
        return ResponseEntity.ok(cars);
    }

    @PutMapping("/{id}/sold")
    public String markAsSold(@PathVariable Long id) {


        //서비스 실행 결과를 그대로 문자열로 반환
        return carService.markAsSold(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok("차량이 성공적으로 삭제되었습니다.");
    }

}