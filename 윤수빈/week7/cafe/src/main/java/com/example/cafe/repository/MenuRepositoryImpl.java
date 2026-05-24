package com.example.cafe.repository;

import com.example.cafe.model.Menu;
import org.springframework.stereotype.Repository;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Repository
//Repository: 다른 클래스에서 자동 주입 가능
public class MenuRepositoryImpl implements MenuRepository {
    //implements: MenuRepository 인터페이스의 규칙(메뉴 조회, 수정) 따르게함 단, findAll()save() 같은 메서드를 구현해야 함.(구현시키기)

    private final List<Menu> menuList = new ArrayList<>();
    //final을 이용하여 자체 변경 방지



    private Long sequence = 1L;
    //1L -> 긴 int(Long)


    @Override
    //메서드 재정의 표지판
    public Menu save(Menu menu) {
        menu.setId(sequence++);
        menuList.add(menu);
        return menu;

    }

    @Override
    public Optional<Menu> findById(Long id) {
        return menuList.stream()
        //메뉴리스트 내부반복처리(외부반복처리 for와는 반대)
                .filter(menu -> menu.getId().equals(id))
                //filter: 조건에 맞는 데이터만 남기기
                .findFirst();
    }


    @Override
    public List<Menu> findAll() {
        return menuList;
    }




    @Override
    public void update(Long id, String name, int price, String category) {
        Optional<Menu> optionalMenu = findById(id);
        //안전한 예외처리(비어 있는 optional 자체는 null) -> 메뉴가 있을 수도 있고 없을 수 도 있기 때문, 없을떄 null 값이 뜨면 에러방지

        if (optionalMenu.isPresent())
        //isPresent() optional 안에 Menu가 있는지 확인함. 메뉴가 있으면~
        {
            //메뉴가 있으면 수정(가변성 -> model.Menu를 바꿨으니 따로 menuList.save() 같은 걸 호출 안 해도 됨)
            Menu menu = optionalMenu.get(); //Menu 바꾸기
            menu.setName(name);
            menu.setPrice(price);
            menu.setCategory(category);
        }


    }


}

