package org.example.week9assignment;

import org.springframework.stereotype.Service;
import java.util.List;

//@Service -> 이 클래스가 비즈니스 로직을 담당하는 컴포넌트다. 선언
//controller와 repository 사이에서 중간 다리 역할을 하며 규칙을 검증
@Service
public class CarService {

    //생성자 주입 -> CarRepository 호출
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    //repository의 save()는 새 엔티티를 등록할 때, 기존 엔티티를 수정해서 저장할 때 사용
    public Car registerCar(Car car) {
        return carRepository.save(car);
    }

    //JpaRepository가 기본으로 제공하는 findAll() 메서드 -> 전체 조회 딸깍
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }


    public List<Car> getCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }


    public List<Car> getAvailableCars() {
        return carRepository.findBySold(false);
    }

    //findById() + save() 구조, 예외 처리
    public String markAsSold(Long id) {
        Car car = carRepository.findById(id).orElse(null);

        //1. 차량이 없는 경우 처리
        if (car == null) {
            return "존재하지 않는 차량입니다.";
        }


        //2. 이미 판매된 차량인 경우 메시지 반환
        if (car.isSold()) {
            return "이미 판매된 차량입니다";

        }



        //3. 정상 처리 시 true로 변경 후 save()
        car.setSold(true);
        carRepository.save(car);
        return "판매 완료 처리가 되었습니다.";

    }

    //무작정 삭제(deleteById)하기 전에 existsById()로 진짜 데이터가 있는지 먼저 검사
    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new IllegalArgumentException("없는 차량 ID입니다.");
        }
        carRepository.deleteById(id);
    }
}