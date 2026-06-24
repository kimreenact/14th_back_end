# 게시글 관리 API

8주차 과제 - REST API 설계(CRUD) + Swagger 문서화

## 실행 방법

1. 프로젝트를 클론한다.
2. IntelliJ에서 `PostsApplication`을 실행한다.
3. 서버는 `http://localhost:8080`에서 동작한다.

- Swagger UI: `http://localhost:8080/swagger-ui.html`

## 사용 기술

- Java 17
- Spring Boot
- springdoc-openapi (Swagger)

## API 명세서

### 1. 게시글 등록

- Method: `POST`
- URL: `/api/posts`

요청
```json
{
  "title": "첫 번째 게시글",
  "content": "안녕하세요",
  "author": "박서준"
}
```

응답
```json
{
  "id": 1,
  "title": "첫 번째 게시글",
  "content": "안녕하세요",
  "author": "박서준"
}
```

### 2. 게시글 전체 조회

- Method: `GET`
- URL: `/api/posts`

응답
```json
[
  {
    "id": 1,
    "title": "첫 번째 게시글",
    "content": "안녕하세요",
    "author": "박서준"
  }
]
```

### 3. 게시글 상세 조회

- Method: `GET`
- URL: `/api/posts/{id}`

응답
```json
{
  "id": 1,
  "title": "첫 번째 게시글",
  "content": "안녕하세요",
  "author": "박서준"
}
```

### 4. 게시글 수정

- Method: `PATCH`
- URL: `/api/posts/{id}`

요청
```json
{
  "title": "수정된 제목",
  "content": "수정된 내용",
  "author": "박서준"
}
```

응답
```json
{
  "id": 1,
  "title": "수정된 제목",
  "content": "수정된 내용",
  "author": "박서준"
}
```

### 5. 게시글 삭제

- Method: `DELETE`
- URL: `/api/posts/{id}`

응답
```json
{
  "message": "게시글이 삭제되었습니다."
}
```

### 예외 처리

- 존재하지 않는 id를 조회/수정/삭제할 경우 예외가 발생한다.