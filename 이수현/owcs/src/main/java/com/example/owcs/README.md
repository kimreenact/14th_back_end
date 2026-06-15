# 🎮 OWCS 선수 관리 API

오버워치 팀 선수 정보를 관리하는 REST API입니다.

## 기술 스택
- Java 17
- Spring Boot 3.4.1
- Springdoc OpenAPI (Swagger) 2.3.0
- Lombok

## 프로젝트 구조
src/main/java/com/example/owcs/
├── controller/OwcsController.java
├── service/OwcsService.java
├── repository/OwcsRepository.java
├── domain/Owcs.java
└── dto/
├── OwcsCreateRequest.java
├── OwcsUpdateRequest.java
└── OwcsResponse.java

## Swagger UI
http://localhost:8080/swagger-ui/index.html

## API 명세서

### 1. 선수 등록
- Method: POST
- URL: /api/players
- Request: { "team": "Lunatic-Hai", "nickname": "RYUJEHONG", "position": "healer", "heros": "ana" }
- Response: { "id": 1, "team": "Lunatic-Hai", "nickname": "RYUJEHONG", "position": "healer", "heros": "ana" }

### 2. 선수 전체 조회
- Method: GET
- URL: /api/players
- Response: 선수 전체 목록 배열

### 3. 선수 상세 조회
- Method: GET
- URL: /api/players/{id}
- Response: 해당 id 선수 정보
- 예외: 없는 id 조회 시 IllegalArgumentException 발생

### 4. 선수 정보 수정
- Method: PATCH
- URL: /api/players/{id}
- Request: { "team": "T1", "nickname": "Profit", "position": "dps", "heros": "tracer" }
- Response: 수정된 선수 정보

### 5. 선수 삭제
- Method: DELETE
- URL: /api/players/{id}
- Response: { "message": "선수 정보가 삭제되었습니다." }
- 예외: 없는 id 삭제 시 IllegalArgumentException 발생