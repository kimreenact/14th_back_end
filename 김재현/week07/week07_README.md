# 카페 메뉴 관리 서비스

## 각 계층의 역할

- **Controller**: 사용자의 HTTP 요청을 받아 Service를 호출하고, 결과를 뷰에 전달한다.
- **Service**: 비즈니스 로직을 처리한다. Controller와 Repository 사이에서 데이터를 가공한다.
- **Repository**: 데이터를 저장하고 조회한다. 현재는 ArrayList로 메모리에 데이터를 저장한다.

---

## MVC와 DI/IoC 적용

### MVC 패턴
- **Model**: `Menu` 객체가 데이터를 담는 역할을 한다.
- **View**: Thymeleaf 템플릿(`menu-list.html`, `menu-detail.html`, `menu-form.html`)이 화면을 담당한다.
- **Controller**: `MenuController`가 요청을 받아 Model에 데이터를 담아 View로 전달한다.

### DI / IoC
- `MenuController`는 `MenuService`를, `MenuService`는 `MenuRepository`를 생성자 주입으로 받는다.
- 객체를 직접 생성하지 않고 Spring이 의존성을 주입해준다. 이것이 IoC(제어의 역전)다.


## 느낀점
- 기존에 사용하던 자바와 느낌이 많이 달라 그동안 했던 과제 중 가장 어려웠던 과제였습니다. 하지만 하다보니 스프링이 어떻게 동작하는 지 알 것 같고,
완벽히 이해하게 된다면 정말 좋은 개발 방식이 될 수 있을 것이라 생각했습니다.
