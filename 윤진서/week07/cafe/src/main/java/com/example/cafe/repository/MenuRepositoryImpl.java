/*
ArrayList로 메뉴 데이터 저장
save(),findById(), findAll(), update()구현
 */
package com.example.cafe.repository;
import com.example.cafe.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class MenuRepositoryImpl implements MenuRepository{
    private final List<Menu> menus = new ArrayList<>();
    private Long sequence = 0L;

    @Override
    public Menu save(Menu menu) {
        menu.setId(++sequence);
        menus.add(menu);
        return menu;
    }

    @Override
    public Optional<Menu> findById(Long id){
        for (Menu menu : menus) {
            if(menu.getId().equals(id)) {
                return Optional.of(menu);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Menu> findAll() {
        return new ArrayList<>(menus);
    }

    @Override
    public void update(Long id, String name, int price, String category) {
        Menu menu = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 없습니다."));
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategory(category);

    }
}
