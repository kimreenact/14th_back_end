# 📋 LikeLion 게시판 API

Spring Boot 기반의 인메모리 게시판 REST API입니다.

---

## 🛠️ 기술 스택

- Java / Spring Boot
- SpringDoc OpenAPI (Swagger UI)
- In-Memory 저장소 (ArrayList)

---

- 기본 포트: `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`

---

## 📦 공통 사항

| 항목 | 내용 |
|------|------|
| Base URL | `/noticeboard` |
| Content-Type | `application/json` |
| 데이터 저장 방식 | 인메모리 (서버 재시작 시 초기화) |

---

## 🔗 API 명세

### 1. 게시물 등록

| 항목 | 내용 |
|------|------|
| **Method** | `POST` |
| **URL** | `/noticeboard` |
| **설명** | 새로운 게시물을 등록합니다. |

**Request Body**

```json
{
  "title": "제목",
  "content": "안녕하세요",
  "author": "홍길동"
}
```

| 필드 | 타입 | 설명 |
|------|------|------|
| `title` | String | 게시글 제목 |
| `content` | String | 게시글 내용 |
| `author` | String | 작성자 |

**Response Body** `200 OK`

```json
{
  "id": 1,
  "title": "제목",
  "Content": "안녕하세요",
  "autor": "홍길동"
}
```

---

### 2. 모든 게시물 조회

| 항목 | 내용 |
|------|------|
| **Method** | `GET` |
| **URL** | `/noticeboard` |
| **설명** | 등록되어 있는 모든 게시물을 조회합니다. |

**Response Body** `200 OK`

```json
[
  {
    "id": 1,
    "title": "제목",
    "Content": "안녕하세요",
    "autor": "홍길동"
  },
  {
    "id": 2,
    "title": "두 번째 제목",
    "Content": "반갑습니다",
    "autor": "김철수"
  }
]
```

---

### 3. 특정 게시물 조회

| 항목 | 내용 |
|------|------|
| **Method** | `GET` |
| **URL** | `/noticeboard/{id}` |
| **설명** | 특정 게시물의 세부 내용을 가져옵니다. |

**Path Variable**

| 파라미터 | 타입 | 설명 |
|----------|------|------|
| `id` | Long | 조회할 게시글 ID |

**Response Body** `200 OK`

```json
{
  "id": 1,
  "title": "제목",
  "Content": "안녕하세요",
  "autor": "홍길동"
}
```

**Error Response** `400 Bad Request`

```json
{
  "error": "존재하지 않는 게시글입니다. id=1"
}
```

---

### 4. 게시물 수정

| 항목 | 내용 |
|------|------|
| **Method** | `PATCH` |
| **URL** | `/noticeboard/{id}` |
| **설명** | 게시물의 내용을 수정합니다. |

**Path Variable**

| 파라미터 | 타입 | 설명 |
|----------|------|------|
| `id` | Long | 수정할 게시글 ID |

**Request Body**

```json
{
  "title": "수정된 제목",
  "content": "수정된 내용",
  "author": "홍길동"
}
```

| 필드 | 타입 | 설명 |
|------|------|------|
| `title` | String | 수정할 게시글 제목 |
| `content` | String | 수정할 게시글 내용 |
| `author` | String | 수정할 작성자 |

**Response Body** `200 OK`

```json
{
  "id": 1,
  "title": "수정된 제목",
  "content": "수정된 내용",
  "author": "홍길동"
}
```

**Error Response** `400 Bad Request`

```json
{
  "error": "존재하지 않는 게시글입니다. id=1"
}
```

---

### 5. 게시물 삭제

| 항목 | 내용 |
|------|------|
| **Method** | `DELETE` |
| **URL** | `/noticeboard/{id}` |
| **설명** | id를 통해 특정 게시물을 삭제합니다. |

**Path Variable**

| 파라미터 | 타입 | 설명 |
|----------|------|------|
| `id` | Long | 삭제할 게시글 ID |

**Response Body** `200 OK`

```json
{
  "message": "게시글이 삭제되었습니다."
}
```

**Error Response** `400 Bad Request`

```json
{
  "error": "존재하지 않는 게시글입니다. id=1"
}
```

---

## 📁 프로젝트 구조

```
src/main/java/com/likeLion/LikeLion_SpringBoot_Assignment/
├── Controller/
│   └── NoticeboardController.java    # REST API 엔드포인트
├── Service/
│   └── NoticeBoardService.java       # 비즈니스 로직
├── Repository/
│   └── NoticeBoardRepository.java    # 인메모리 데이터 저장소
├── Domain/
│   └── Post.java                     # 게시글 엔티티
├── DTO/
│   ├── Request/
│   │   ├── NoticeBoardCreateDTO.java # 게시글 생성 요청 DTO
│   │   └── NoticeBoardUpdateDTO.java # 게시글 수정 요청 DTO
│   └── Response/
│       └── NoticeBoardResponseDTO.java # 게시글 응답 DTO
└── Exception/
    └── GlobalExceptionHandler.java   # 전역 예외 처리
```

---

## ⚠️ 예외 처리

존재하지 않는 게시글 ID로 **조회 / 수정 / 삭제** 요청 시 `400 Bad Request`와 함께 아래 형식의 에러 메시지를 반환합니다.

```json
{
  "error": "존재하지 않는 게시글입니다. id={id}"
}
```