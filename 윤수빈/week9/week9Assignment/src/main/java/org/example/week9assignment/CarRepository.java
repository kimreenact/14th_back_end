package org.example.week9assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//JpaRepository<엔티티타입, PK타입>을 상속만 받아도 기본 CRUD(save, findAll, findById, deleteById, etc...) 사용가능
public interface CarRepository extends JpaRepository<Car, Long> {


    List<Car> findByBrand(String brand);




    List<Car> findBySold(boolean sold);
}