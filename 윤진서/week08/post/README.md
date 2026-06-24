# 8주차 과제: 게시글 관리 CRUD REST API + Swagger 문서화

Spring Boot 기반의 **게시글 관리 CRUD REST API** 입니다.
`Controller - Service - Repository - DTO` 계층을 분리하였으며, Swagger(springdoc-openapi)로 API 문서를 제공합니다.

---

## 1. 기술 스택

| 구분 | 내용 |
|------|------|
| Language | Java 17 |
| Framework | Spring Boot 4.1.0 |
| Build | Gradle |
| 의존성 | Spring Web, Thymeleaf, Lombok |
| 문서화 | springdoc-openapi (Swagger UI) 3.0.3 |
| 검증 | spring-boot-starter-validation |
| 저장소 | In-Memory (ConcurrentHashMap) |

---

## 2. 프로젝트 구조

```
post
└── src/main/java/com/example/post
    ├── PostApplication.java          # 메인 클래스
    ├── controller
    │   ├── PostController.java        # REST API (@Tag, @Operation)
    │   └── HomeController.java        # Thymeleaf 홈 화면
    ├── service
    │   └── PostService.java           # 비즈니스 로직
    ├── repository
    │   └── PostRepository.java        # 인메모리 저장소
    ├── domain
    │   └── Post.java                  # 도메인 객체 (Lombok)
    ├── dto
    │   ├── PostCreateRequest.java     # 생성 요청 DTO (record, @Schema)
    │   ├── PostUpdateRequest.java     # 수정 요청 DTO (record, @Schema)
    │   └── PostResponse.java          # 응답 DTO (record, @Schema)
    ├── exception
    │   ├── PostNotFoundException.java # 게시글 미존재 예외
    │   ├── ErrorResponse.java         # 에러 응답 DTO
    │   └── GlobalExceptionHandler.java# 전역 예외 처리 (404/400)
    └── config
        └── SwaggerConfig.java         # Swagger 기본 정보
```

---

## 3. 실행 방법

```bash
# 프로젝트 루트에서
./gradlew bootRun
```

- 홈 화면(Thymeleaf): `http://localhost:8080/`
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI 문서(JSON): `http://localhost:8080/v3/api-docs`

---

## 4. API 명세서

Base URL: `http://localhost:8080`

| 기능 | Method | URL | 성공 상태 코드 |
|------|--------|-----|----------------|
| 게시글 생성 | POST | `/api/posts` | 201 Created |
| 게시글 전체 조회 | GET | `/api/posts` | 200 OK |
| 게시글 상세 조회 | GET | `/api/posts/{id}` | 200 OK |
| 게시글 수정 | PATCH | `/api/posts/{id}` | 200 OK |
| 게시글 삭제 | DELETE | `/api/posts/{id}` | 204 No Content |

---

### 4-1. 게시글 생성 — `POST /api/posts`

**Request Body**

| 필드 | 타입 | 필수 | 설명 |
|------|------|------|------|
| title | String | O | 제목 |
| content | String | O | 내용 |
| author | String | O | 작성자 |

```json
{
  "title": "첫 번째 게시글",
  "content": "안녕하세요. 첫 게시글 내용입니다.",
  "author": "홍길동"
}
```

**Response (201 Created)**

```json
{
  "id": 1,
  "title": "첫 번째 게시글",
  "content": "안녕하세요. 첫 게시글 내용입니다.",
  "author": "홍길동",
  "createdAt": "2025-06-15T10:00:00",
  "updatedAt": "2025-06-15T10:00:00"
}
```

---

### 4-2. 게시글 전체 조회 — `GET /api/posts`

**Query Parameter**

| 파라미터 | 타입 | 필수 | 설명 |
|----------|------|------|------|
| keyword | String | X | 제목 검색 키워드. 입력 시 제목에 포함된 게시글만 반환 |

- 예시: `GET /api/posts?keyword=게시글`

**Response (200 OK)**

```json
[
  {
    "id": 1,
    "title": "첫 번째 게시글",
    "content": "안녕하세요. 첫 게시글 내용입니다.",
    "author": "홍길동",
    "createdAt": "2025-06-15T10:00:00",
    "updatedAt": "2025-06-15T10:00:00"
  }
]
```

---

### 4-3. 게시글 상세 조회 — `GET /api/posts/{id}`

**Path Variable**

| 파라미터 | 타입 | 설명 |
|----------|------|------|
| id | Long | 게시글 ID |

**Response (200 OK)** — 4-1 응답과 동일한 형태

**Response (404 Not Found)** — 없는 id 조회 시

```json
{
  "status": 404,
  "message": "해당 게시글을 찾을 수 없습니다. id=999",
  "timestamp": "2025-06-15T10:05:00"
}
```

---

### 4-4. 게시글 수정 — `PATCH /api/posts/{id}`

부분 수정 방식입니다. 보낸 필드만 수정되고, 생략한 필드는 기존 값을 유지합니다.

**Request Body**

| 필드 | 타입 | 필수 | 설명 |
|------|------|------|------|
| title | String | X | 수정할 제목 |
| content | String | X | 수정할 내용 |

```json
{
  "title": "수정된 제목",
  "content": "수정된 내용입니다."
}
```

**Response (200 OK)**

```json
{
  "id": 1,
  "title": "수정된 제목",
  "content": "수정된 내용입니다.",
  "author": "홍길동",
  "createdAt": "2025-06-15T10:00:00",
  "updatedAt": "2025-06-15T10:10:00"
}
```

**Response (404 Not Found)** — 없는 id 수정 시 위와 동일한 에러 응답.

---

### 4-5. 게시글 삭제 — `DELETE /api/posts/{id}`

**Path Variable**

| 파라미터 | 타입 | 설명 |
|----------|------|------|
| id | Long | 게시글 ID |

**Response (204 No Content)** — 본문 없음
**Response (404 Not Found)** — 없는 id 삭제 시 위와 동일한 에러 응답.

---

## 5. 예외 처리

| 상황 | 상태 코드 | 설명 |
|------|-----------|------|
| 없는 id 조회/수정/삭제 | 404 Not Found | `PostNotFoundException` → `GlobalExceptionHandler` |
| 필수 입력값 누락 (생성 시) | 400 Bad Request | `@Valid` 검증 실패 |

---

## 6. 과제 키워드 

| 키워드 | 적용 위치 |
|--------|-----------|
| DTO의 중요성 | 도메인(Post)을 직접 노출하지 않고 Request/Response DTO로 분리 |
| Java Record | `PostCreateRequest`, `PostUpdateRequest`, `PostResponse` 모두 record 사용 |
| Path Variable | `GET/PATCH/DELETE /api/posts/{id}` 의 `@PathVariable id` |
| Query Parameter | `GET /api/posts?keyword=` 의 `@RequestParam keyword` |

---

