package com.example.week07hw.repository;

import com.example.week07hw.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MenuRepositoryImpl implements MenuRepository {
    private final List<Menu> menuList = new ArrayList<>();
    private long sequence = 0L;

    // 메뉴 저장
    @Override
    public Menu save(Menu menu){
        menu.setId(++sequence);
        menuList.add(menu);
        return menu;
    };

    // id로 메뉴 한 개 조회
    @Override
    public Optional<Menu> findById(Long id){
        return menuList.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    };

    // 전체 메뉴 조회
    @Override
    public List<Menu> findAll(){
        return menuList;
    };

    // 메뉴 수정
    @Override
    public void update(Long id, String name, int price, String category){
        findById(id).ifPresent(menu -> {
            menu.setName(name);
            menu.setPrice(price);
            menu.setCategory(category);
        });
    };
}