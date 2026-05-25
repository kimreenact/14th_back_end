# 카페 메뉴 관리 서비스

## 1. 각 계층의 역할

**Model**
메뉴 데이터(id, 이름, 가격, 카테고리)를 담는 클래스다.

**Repository**
데이터를 저장하고 불러오는 역할이다. ArrayList에 메뉴를 저장했다.

**Service**
기능을 처리하는 곳이다. Controller에서 요청을 받아 Repository를 호출한다.

**Controller**
사용자의 요청을 받아서 Service를 부르고, 결과를 화면에 넘겨준다.

**DTO**
계층 간에 데이터를 전달할 때 쓰는 객체다.

---

## 2. MVC와 DI/IoC 적용

**MVC**
- Model =  Menu 클래스
- View =  Thymeleaf HTML 파일
- Controller = MenuController

각 역할이 분리되어 있어서 한 부분을 수정해도 다른 부분에 영향이 없다.

**DI / IoC**
@RequiredArgsConstructor를 사용해서 객체를 직접 생성하지 않고 스프링이 자동으로 주입해준다. @Service, @Repository 어노테이션을 붙이면 스프링이 알아서 관리한다.

---

## 3. 느낀점

**어려웠던 점**
어떤 코드를 어느 계층에 작성해야 하는지 처음에 헷갈렸다.

**더 구현해보고 싶은 기능**
 DB를 연동까지 해보고싶다.

**스프링을 쓰면서 편리했던 점**
어노테이션만 붙이면 복잡한 설정 없이 기능이 동작해서 편리했다.
