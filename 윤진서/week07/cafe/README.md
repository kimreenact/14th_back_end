

a. 각 계층이 어떤 역할을 하는지 간단히 작성 
-Controller (`MenuController`)
 역할: 사용자의 요청을 가장 먼저 받는 계층 
 주요 업무:
  1.URL을 매핑
  2.사용자가 보낸 데이터가 올바른지 확인
  3.비즈니스 로직(service)을 호출하고 결과를 화면(view/JASON)으로 반환

-Service (`MenuService`)
 역할: 실제 비즈니스 로직이 실행되는 계층 
 주요 업무: 
  1.비즈니스 로직 수행(계산, 복잡한 규칙 적용 등)
  2.여러 저장소(Repository)를 조합하여 데이터를 가공 
  3.컨트롤러와 저장소 사이의 중간 다리 역할 

  Controller로부터 요청을 받아 Repository를 호출하고, DTO를 도메인 객체(`Menu`)로 변환하는 작업도 여기서 처리.

-Repository (`MenuRepository` / `MenuRepositoryImpl`)
 역할: 데이터를 저장하고 조회하는 계층 
 주요 업무: 
  1.DB 연결 및 데이터 조회/저장/수정/삭제 (CRUD)
  2.데이터 저장 기술이 바뀌어도 다른 계층에 영향을 주지 않도록 보호


-Model (`Menu', `MenuRequestDto`)
 데이터 구조
 `Menu`: 실제 도메인 객체
 `MenuRequestDto`: 폼에서 전달되는 입력값을 받는 전용 객체입니다.

-View (`menu-list.html`, `menu-form.html`, `menu-detail.html`)
 Thymeleaf 템플릿으로 사용자에게 보여줄 화면을 렌더링.



b. MVC와 DI/IoC 어떻게 적용되었는지 간단히 작성 

-MVC 패턴

```
사용자 요청
    ↓
Controller (MenuController) — 요청 수신, Service 호출
    ↓
Service (MenuService) — 비즈니스 로직 처리
    ↓
Repository (MenuRepositoryImpl) — 데이터 처리
    ↓
Controller — Model에 결과 담기
    ↓
View (Thymeleaf HTML) — 화면 렌더링
```

각 계층이 역할에 따라 분리되어 있어서 View를 바꿔도 Controller/Service에 영향x
DB를 교체해도 Repository 구현체만 바꾸면 o

-DI (의존성 주입)

객체를 직접 생성하지 않고 Spring이 주입해줍니다.
생성자 주입 사용

```java
// new로 직접 생성하지 않음
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService; // Spring이 주입
}

@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository; // Spring이 주입
}
```

-IoC (제어의 역전)

`@Controller`, `@Service`, `@Repository` 어노테이션을 붙여 
스프링 컨테이너가 객체와 메소드룰 호출하는 작업의 제어권을 가지게 되는 것.

-유지보수, 확장성, 테스트성 향상 

```java
// Service는 인터페이스만 알고 있음
private final MenuRepository menuRepository;

// 실제 구현체는 Spring이 알아서 주입
// → MenuRepositoryImpl을 다른 구현체로 교체해도 Service 코드 변경 없음
```

c. 느낀점

이번 과제에서 가장 어려웠던 부분은 Controller에서 URL 매핑이었습니다.  
@ModelAttribute가 폼에서 넘어온 데이터를 자동으로 DTO 객체에 담아준다는 것과, @PathVariable이 `/menus/{id}`처럼 URL 경로에 포함된 값을 메서드 파라미터로 받아온다는 것도
처음에는 어떻게 동작하는지 파악하기 어려웠습니다. 직접 구현하면서 각 어노테이션의 역할을 이해할 수 있었습니다.


