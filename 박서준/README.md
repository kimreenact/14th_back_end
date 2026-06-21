1.
Controller
사용자가 사이트에서 어떤 정보 클릭?하면 
Service로 전달, 결과를 화면에 보여주는 역할
html파일 이용한다

Service
실제 기능하는 역할 (업데이트 수정 찾기 등)

Repository
데이터를 저장한다

2.
M 은 Menu 
V 는 resources에 있는 html 파일들 
C 는 MenuController

3.
매핑안에 메소드를 적는게 어려웠음
1)controller에서 redirect..? 적는거
레포지토리 impl안의 메소드 채우는부분
정보가 너무많아서 어떤 순서로 해야하는지..

2)  특정메뉴 할인 기능 온라인 결제창

3) 메서드 쓸떄 반복되는게 많았는데 @로 간단히 쓸수있어 좋았음

