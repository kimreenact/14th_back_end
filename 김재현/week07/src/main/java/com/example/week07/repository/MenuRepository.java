// repository/MenuRepository.java
package com.example.week07.repository;

import com.example.week07.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository {
    Menu save(Menu menu);           // 메뉴 저장

    Optional<Menu> findById(Long id); // id로 메뉴 한 개 조회

    List<Menu> findAll();           // 전체 메뉴 조회

    void update(Long id, String name, int price, String category); // 메뉴 수정
}