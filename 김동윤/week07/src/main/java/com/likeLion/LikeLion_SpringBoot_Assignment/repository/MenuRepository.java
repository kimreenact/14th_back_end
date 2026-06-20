package com.likeLion.LikeLion_SpringBoot_Assignment.repository;


import com.likeLion.LikeLion_SpringBoot_Assignment.model.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {
    Menu save(Menu menu);           // 메뉴 저장
    Optional<Menu> findById(Long id); // id로 메뉴 한 개 조회
    List<Menu> findAll();           // 전체 메뉴 조회
    void update(Long id, String name, int price, String category); // 메뉴 수정
}
