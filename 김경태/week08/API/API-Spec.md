# Week08HW API Specification

## 개요

편의점(Store)과 편의점 재고(Stock)를 관리하는 REST API이다.

---

# Store API

기본 경로

```http
/api/store
```

---

## 1. 편의점 전체 조회

### Request

```http
GET /api/store
```

### Response

```json
[
  {
    "id": 1,
    "name": "CU 명지대점"
  },
  {
    "id": 2,
    "name": "GS25 명지대점"
  }
]
```

### Response DTO

StoreResponseDto

---

## 2. 편의점 추가

### Request

```http
POST /api/store/add
```

### Request Body

```json
{
  "name": "CU 명지대점"
}
```

### Request DTO

StoreRequestDto

### Response

```json
{
  "id": 1,
  "name": "CU 명지대점"
}
```

### Response DTO

StoreResponseDto

---

## 3. 편의점 삭제

### Request

```http
DELETE /api/store/{storeId}
```

### Path Variable

| Name    | Type | Description |
| ------- | ---- | ----------- |
| storeId | Long | 편의점 ID      |

### Response

```http
204 No Content
```

---

# Stock API

기본 경로

```http
/api/store/{storeId}/stock
```

---

## 1. 편의점 전체 상품 조회

### Request

```http
GET /api/store/{storeId}/stock
```

### Path Variable

| Name    | Type | Description |
| ------- | ---- | ----------- |
| storeId | Long | 편의점 ID      |

### Response

```json
[
  {
    "id": 1,
    "productName": "코카콜라",
    "quantity": 50
  },
  {
    "id": 2,
    "productName": "사이다",
    "quantity": 30
  }
]
```

### Response DTO

ProductResponseDto

---

## 2. 특정 상품 조회

### Request

```http
GET /api/store/{storeId}/stock/{productId}
```

### Path Variable

| Name      | Type | Description |
| --------- | ---- | ----------- |
| storeId   | Long | 편의점 ID      |
| productId | Long | 상품 ID       |

### Response

```json
{
  "id": 1,
  "storeId": 1,
  "productName": "코카콜라",
  "price": 2000,
  "quantity": 50
}
```

### Response DTO

StockResponseDto

---

## 3. 상품 등록

### Request

```http
POST /api/store/{storeId}/stock/add
```

### Request Body

```json
{
  "productName": "코카콜라",
  "price": 2000,
  "quantity": 50
}
```

### Request DTO

StockRequestDto

### Response

```json
{
  "id": 1,
  "storeId": 1,
  "productName": "코카콜라",
  "price": 2000,
  "quantity": 50
}
```

### Response DTO

StockResponseDto

---

## 4. 상품 수량 수정

### Request

```http
PATCH /api/store/{storeId}/stock/{productId}
```

### Request Body

```json
{
  "quantity": 100
}
```

### Request DTO

StockPatchDto

### Response

```json
{
  "id": 1,
  "storeId": 1,
  "productName": "코카콜라",
  "price": 2000,
  "quantity": 100
}
```

### Response DTO

StockResponseDto

---

## 5. 상품 전체 수정

### Request

```http
PUT /api/store/{storeId}/stock/{productId}
```

### Request Body

```json
{
  "productName": "코카콜라 제로",
  "price": 2200,
  "quantity": 100
}
```

### Request DTO

StockRequestDto

### Response

```json
{
  "id": 1,
  "storeId": 1,
  "productName": "코카콜라 제로",
  "price": 2200,
  "quantity": 100
}
```

### Response DTO

StockResponseDto

---

# DTO 명세

## StoreRequestDto

```json
{
  "name": "CU 명지대점"
}
```

## StoreResponseDto

```json
{
  "id": 1,
  "name": "CU 명지대점"
}
```

## StockRequestDto

```json
{
  "productName": "코카콜라",
  "price": 2000,
  "quantity": 50
}
```

## StockPatchDto

```json
{
  "quantity": 100
}
```

## ProductResponseDto

```json
{
  "id": 1,
  "productName": "코카콜라",
  "quantity": 50
}
```

## StockResponseDto

```json
{
  "id": 1,
  "storeId": 1,
  "productName": "코카콜라",
  "price": 2000,
  "quantity": 50
}
```
