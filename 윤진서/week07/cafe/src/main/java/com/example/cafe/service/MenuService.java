/*
생성자 주입으로 MenuRepository 주입
각 기능을 Service에서 Repository 호출
 */

package com.example.cafe.service;

import com.example.cafe.dto.MenuRequestDto;
import com.example.cafe.model.Menu;
import com.example.cafe.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    //저장
    public Menu save(MenuRequestDto dto) {
        Menu menu = new Menu(null, dto.getName(), dto.getPrice(), dto.getCategory());
        return menuRepository.save(menu);
    }
    //id
    public Optional<Menu> findById(Long id) {
        return menuRepository.findById(id);
    }
    //전체 조회
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }
    //수정
    public void update(Long id, String name, int price, String category) {
        menuRepository.update(id, name, price, category);
    }
}
