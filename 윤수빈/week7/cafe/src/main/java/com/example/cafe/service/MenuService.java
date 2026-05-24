package com.example.cafe.service;



import com.example.cafe.dto.MenuRequestDto;
//Menu 요청 확인
import com.example.cafe.model.Menu;
//진짜 Menu 객체 만들려고
import com.example.cafe.repository.MenuRepository;
//메뉴 보관소

import lombok.RequiredArgsConstructor;
//lombok 편의도구: MenuService가 MenuRepository에서 불러와 자동으로 작동
import org.springframework.stereotype.Service;
//Spring에게 MenuService 클래스가 우두머리임을 담당한다고 알려줌



import java.util.List;
import java.util.Optional;


@Service //역할분리: Dto와 Repository 사이에서 조정하는 타워
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    //캡슐화(private), final로 변경 금지

    public Menu save(MenuRequestDto dto) {

        Menu menu = new Menu(
                null,
                dto.getName(),
                dto.getPrice(),
                dto.getCategory());
                //Repository에 넣기 전에 Menu 새객체를 만들어서 id를 null로 만들기(Dto안엔 순서가 없음)



        return menuRepository.save(menu);
        //null인 id는 너가 저장해라
    }

    public List<Menu> findAll() {
        return menuRepository.findAll();

    }

    public Optional<Menu> findById(Long id){
    //없을 수도 있으니까 Optional(null값 에러 방지)

        return menuRepository.findById(id);

    }

    public void update(Long id, MenuRequestDto dto) {
    //(몇 번 메뉴를, 어떤 값(dto)로) 바꿀건지

        menuRepository.update(
        //가변성 활용: 원본에서 바꾸면 따로 save() 쓸 이유가 없음
                id,
                dto.getName(),
                dto.getPrice(),
                dto.getCategory());



    }

}