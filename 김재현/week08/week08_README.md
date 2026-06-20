# PostPractice

게시글(Post) 관리를 위한 CRUD REST API입니다.
Controller / Service / Repository / DTO 계층을 분리하고, 데이터를 인메모리(Map)에 저장합니다.

## 기술 스택

| 구분 | 내용 |
| --- | --- |
| Language | Java 17 |
| Framework | Spring Boot 4.0.6 |
| API 문서 | springdoc-openapi (Swagger UI) 3.0.2 |
| 빌드 도구 | Gradle |
| 데이터 저장 | In-Memory (`Map`) |

## 실행 방법

```bash
./gradlew bootRun
```

실행 후 기본 포트는 `8080`입니다.

- API 기본 경로: `http://localhost:8080/api/posts`
- Swagger UI: `http://localhost:8080/swagger-ui.html`

> 데이터는 메모리에 저장되므로 애플리케이션을 재시작하면 모두 초기화됩니다.

## 프로젝트 구조

```
com.example.PostPractice
├── controller        // HTTP 요청/응답 처리 (PostRestController)
├── service           // 비즈니스 로직, DTO ↔ 도메인 변환, 예외 판단 (PostService)
├── repository        // 데이터 저장/조회 (PostRepository)
├── domain            // 도메인 객체 (Post)
├── dto
│   ├── request       // PostCreateRequest, PostUpdateRequest
│   └── response      // PostResponse
└── exception         // PostNotFoundException, GlobalExceptionHandler
```

각 계층은 자기 역할만 담당합니다. Controller는 HTTP와 자바 객체를 중계하고, Service는 변환·판단·흐름 조율을, Repository는 저장·조회만 수행합니다.

## API 명세

### 엔드포인트 요약

| 기능 | Method | URL |
| --- | --- | --- |
| 게시글 생성 | POST | `/api/posts` |
| 게시글 전체 조회 | GET | `/api/posts` |
| 게시글 상세 조회 | GET | `/api/posts/{id}` |
| 게시글 수정 | PATCH | `/api/posts/{id}` |
| 게시글 삭제 | DELETE | `/api/posts/{id}` |

---

### 1. 게시글 생성

`POST /api/posts`

새 게시글을 등록합니다. `id`는 서버에서 자동으로 부여됩니다.

**Request Body**

| 필드 | 타입 | 필수 | 설명 |
| --- | --- | --- | --- |
| title | String | O | 게시글 제목 |
| author | String | O | 작성자 |
| content | String | O | 본문 내용 |

```json
{
    "title": "첫 번째 글",
    "author": "김재현",
    "content": "안녕하세요"
}
```

**Response** `200 OK`

```json
{
    "id": 1,
    "title": "첫 번째 글",
    "author": "김재현",
    "content": "안녕하세요"
}
```

---

### 2. 게시글 전체 조회

`GET /api/posts`

등록된 모든 게시글을 조회합니다. 게시글이 없으면 빈 배열(`[]`)이 반환됩니다.

**Request** 요청 파라미터 없음

**Response** `200 OK`

```json
[
    {
        "id": 1,
        "title": "첫 번째 글",
        "author": "김재현",
        "content": "안녕하세요"
    },
    {
        "id": 2,
        "title": "두 번째 글",
        "author": "홍길동",
        "content": "반갑습니다"
    }
]
```

---

### 3. 게시글 상세 조회

`GET /api/posts/{id}`

`id`로 특정 게시글을 조회합니다.

**Path Variable**

| 이름 | 타입 | 설명 |
| --- | --- | --- |
| id | Long | 조회할 게시글의 id |

**Response** `200 OK`

```json
{
    "id": 1,
    "title": "첫 번째 글",
    "author": "김재현",
    "content": "안녕하세요"
}
```

존재하지 않는 id이면 `404 Not Found`가 반환됩니다. (아래 [에러 응답](#에러-응답) 참고)

---

### 4. 게시글 수정

`PATCH /api/posts/{id}`

`id`로 특정 게시글을 부분 수정합니다. 보낸 필드만 변경되며, 생략한 필드는 기존 값이 유지됩니다.

**Path Variable**

| 이름 | 타입 | 설명 |
| --- | --- | --- |
| id | Long | 수정할 게시글의 id |

**Request Body**

| 필드 | 타입 | 필수 | 설명 |
| --- | --- | --- | --- |
| title | String | X | 수정할 제목 (생략 시 기존 값 유지) |
| author | String | X | 수정할 작성자 (생략 시 기존 값 유지) |
| content | String | X | 수정할 내용 (생략 시 기존 값 유지) |

예) 제목만 수정하는 경우:

```json
{
    "title": "수정된 제목"
}
```

**Response** `200 OK`

```json
{
    "id": 1,
    "title": "수정된 제목",
    "author": "김재현",
    "content": "안녕하세요"
}
```

존재하지 않는 id이면 `404 Not Found`가 반환됩니다.

---

### 5. 게시글 삭제

`DELETE /api/posts/{id}`

`id`로 특정 게시글을 삭제합니다.

**Path Variable**

| 이름 | 타입 | 설명 |
| --- | --- | --- |
| id | Long | 삭제할 게시글의 id |

**Response** `200 OK`

응답 본문 없음.

존재하지 않는 id이면 `404 Not Found`가 반환됩니다.

---

### 에러 응답

조회·수정·삭제 시 존재하지 않는 id를 요청하면 `404 Not Found`와 함께 에러 메시지가 반환됩니다.

**Response** `404 Not Found`

```
게시글을 찾을 수 없습니다. id = 999
```
