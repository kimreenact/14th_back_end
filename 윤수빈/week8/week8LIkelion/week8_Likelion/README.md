# Week 8 과제: 게시판 CRUD API 명세서

* **Base URL:** `http://localhost:8080`
* **Swagger UI:** `http://localhost:8080/swagger-ui/index.html`

----

## API 엔드포인트 요약

| 기능 | Method | URL | Request Body | Response Status | 예외 처리 (404) |
| --- | --- | --- | --- | --- | --- |
| 1. 게시글 생성 | POST | /api/posts | JSON | 201 Created | - |
| 2. 게시글 전체 조회 | GET | /api/posts | 없음 | 200 OK | - |
| 3. 게시글 상세 조회 | GET | /api/posts/{id} | 없음 | 200 OK | 에러 메시지 반환 |
| 4. 게시글 수정 | PATCH | /api/posts/{id} | JSON | 200 OK | 에러 메시지 반환 |
| 5. 게시글 삭제 | DELETE | /api/posts/{id} | 없음 | 200 OK | 에러 메시지 반환 |

----

## 상세 API 기능 명세

### 1. 게시글 생성

* **Method:** POST
* **URL:** `/api/posts`
* **설명:** 새로운 게시글 데이터를 받아 내부 저장소(ConcurrentHashMap)에 등록합니다.
* **Request Body (JSON):**

```json
{
  "title": "두 번째 게시글",
  "content": "시험 끝난 지 1시간 되었네요",
  "author": "수빈"
}

```

* **Response Body (201 Created):**

```json
{
  "id": 1,
  "title": "두 번째 게시글",
  "content": "시험 끝난 지 1시간 되었네요",
  "author": "수빈"
}

```

----

### 2. 게시글 전체 조회

* **Method:** GET
* **URL:** `/api/posts`
* **설명:** 현재 저장소에 등록된 모든 게시글 목록을 배열 형태로 조회합니다.
* **Response Body (200 OK):**

```json
[
  {
    "id": 1,
    "title": "두 번째 게시글",
    "content": "시험 끝난 지 1시간 되었네요",
    "author": "수빈"
  }
]

```

----

### 3. 게시글 상세 조회

* **Method:** GET
* **URL:** `/api/posts/{id}`
* **설명:** 경로 변수({id})로 지정한 특정 ID의 게시글을 단건 조회합니다.
* **정상 응답 (200 OK):**

```json
{
  "id": 1,
  "title": "두 번째 게시글",
  "content": "시험 끝난 지 1시간 되었네요",
  "author": "수빈"
}

```

* **예외 응답 (404 Not Found - 존재하지 않는 ID 조회 시):**

```json
{
  "error": "해당 ID의 게시글이 존재하지 않습니다. ID: 999"
}

```

----

### 4. 게시글 수정

* **Method:** PATCH
* **URL:** `/api/posts/{id}`
* **설명:** 요청받은 ID의 게시글 제목, 내용, 작성자를 새로운 데이터로 업데이트합니다.
* **Request Body (JSON):**

```json
{
  "title": "수정된 제목입니다",
  "content": "내용도 깔끔하게 수정 완료했습니다.",
  "author": "수빈"
}

```

* **정상 응답 (200 OK):**

```json
{
  "id": 1,
  "title": "수정된 제목입니다",
  "content": "내용도 깔끔하게 수정 완료했습니다.",
  "author": "수빈"
}

```

* **예외 응답 (404 Not Found - 존재하지 않는 ID 수정 시):**

```json
{
  "error": "해당 ID의 게시글이 존재하지 않습니다. ID: 999"
}

```

----

### 5. 게시글 삭제

* **Method:** DELETE
* **URL:** `/api/posts/{id}`
* **설명:** 요청받은 ID의 게시글 데이터를 저장소에서 완전히 제거합니다.
* **정상 응답 (200 OK):**

```json
{
  "message": "게시글이 삭제되었습니다."
}

```

* **예외 응답 (404 Not Found - 존재하지 않는 ID 삭제 시):**

```json
{
  "error": "해당 ID의 게시글이 존재하지 않습니다. ID: 999"
}

```