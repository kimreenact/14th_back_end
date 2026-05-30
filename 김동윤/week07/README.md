# A. 각 계층이 어떤 역할을 하는지 간단히 작성

## Controller

HTTP 요청(Get, Post 등)을 받고 Service 호출 후 View(HTML)를 반환함.

## Service

실제 로직이 들어가는 부분. Controller로부터 데이터를 받은 뒤 값이 유효한지 검증하는 등의 비즈니스 로직을 수행한다.

현재 프로젝트에선 DTO를 받아서 Menu로 전환하는 등의 로직을 수행하고 있다.

## Repository

저장된 데이터에 접근하는 역할이다.

현재 프로젝트에서는 따로 DB를 연결하지 않고 List로 만들었기 때문에 Repository 내부에서 처리하고 있다.

## Model

핵심 데이터 역할. 

현재 프로젝트에서는 메뉴에 들어가는 항목을 담는 객체(메뉴판)를 만드는 객체이다.

## Dto

데이터를 감싸고 계층을 옮겨 다니는 역할

Post 요청과 함께 온 name, price, category 등의 data를 담고 Controller에서 Service로 이동한다. 이후 Menu에 데이터를 넘긴다.


---


# B. MVC와 DI/IoC가 어떻게 적용되었는지 간단히 작성

## MVC

Model - View - Control

### Model

Menu, MenuRepository, MenuService가 데이터와 로직을 담당하고 있다.

### View

각각의 html 문서들이 사용자가 보는 화면을 담당함.

### Control

MenuController가 View에서 요청을 받고 Model로 넘긴다. Model에서 return가 오면 View로 반환한다.

## DI/IoC

기존 자바에서 new를 통해 직접 객체를 생성한 것과 다르게 @RequiredArgsConstrutor를 통해 final로 선언한 객체를 자동 생성한다.

또한 각각의 어노테이션이 붙은 객체들을 Bean으로 생성해서 자동주입한다.

객체 생성을 개발자가 아닌 Spring Boot가 하며 이걸 DI를 통해 구현한다.

---

# C. 느낀점

확실히 규칙에 맞춰서 쓰면 스프링이 알아서 뚝딱뚝딱 연결하고 만들고 하니까 작성하는 코드 양이 줄어든 거 같아서 편하긴 한 거 같다.

다만 POST를 통해 들어온 값이 어떤 식으로 Dto에 들어가는 지, interface만 만들었는데 어떻게 MenuRepositoryImp가 만들어지는 건지 등등에 대해 모르는 부분이 많아서 공부하느라 시간이 많이 소모됐다..ㅠㅠ

AI랑 진짜 며칠동안 싸운듯.. 결국엔 내가 이김 
