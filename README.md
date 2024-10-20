# 주문 관리 시스템 (Order Management System)

## 개요
이 프로젝트는 간단한 주문 관리 시스템입니다. 주문 정보(주문 ID, 고객명, 주문 날짜, 주문 상태)를 메모리 내의 Map을 사용하여 관리합니다. 데이터베이스를 사용하지 않고, 주문 정보는 애플리케이션 실행 중 메모리에 저장됩니다. 또한, AOP를 적용하여 로깅 및 예외 처리를 효율적으로 관리하였으며, 예외 처리를 커스텀하여 사용자에게 유용한 오류 메시지를 제공합니다.

## 주요 기능
- **주문 추가**: 주문 ID, 고객명, 주문 날짜, 주문 상태를 입력받아 새로운 주문을 저장합니다.
- **주문 조회**: 주문 ID를 이용하여 특정 주문의 상세 정보를 조회할 수 있습니다.
- **주문 상태 변경**: 주문 ID를 기반으로 주문 상태를 변경할 수 있습니다.
- **주문 삭제**: 주문 ID를 사용하여 주문을 삭제할 수 있습니다.

## 기술 스택
- **Java**
- **Spring Boot**
- **AOP (Aspect-Oriented Programming)**
- **Custom Exception Handling**

## API 사용 예시
1.  주문 추가
- POST /save

```json
{
    "orderId" : "2",
    "customerName" : "taeeun",
    "orderDate" : "2024-03-01 12:12:13",
    "status" : "processing"
}
```
2.  주문 조회
- GET /selectOrder?orderId=

3.  주문 상태 변경
- PUT /updateOrder
```json
{
    "orderId" : "4",
    "status" : "CANCELED"
}
```
4.  주문 삭제
- DELETE /deleteOrder
```json
{
    "orderId" : "4"
}
```
## 예외처리
- 모든 예외는 커스텀 예외 클래스를 통해 관리됩니다.
- 예를 들어, 유효하지 않은 주문 ID를 조회할 경우 OrderNotFoundException이 발생합니다.

## 클래스 다이어그램
아래는 핵심 클래스의 간단한 설명과 클래스 다이어그램입니다.
1. OrderController
  - 역할: 클라이언트의 HTTP 요청을 처리하고, 서비스 레이어와 상호작용하여 주문 데이터를 반환합니다.
  - 책임: 주문 추가, 조회, 업데이트 및 삭제를 처리하는 메서드를 제공합니다.
     
2. OrderService
  - 역할: 주문 관련 비즈니스 로직을 처리하는 서비스 클래스입니다.
  - 책임: 주문을 추가하고, 조회하고, 상태를 업데이트하며, 삭제하는 메서드를 제공합니다.

3. OrderDto
  - 역할: 주문 정보를 표현하는 데이터 전송 객체(DTO)입니다.
  - 책임: 주문의 ID, 고객 이름, 주문 날짜 및 상태를 포함합니다.

4. ResponseDto
  - 역할: API 응답 형식을 정의합니다.
  - 책임: 상태 코드, 메시지, 타임스탬프 및 본문을 포함하여 클라이언트에 응답합니다.

![image](https://github.com/user-attachments/assets/a63f9fe9-690d-4be1-ac24-c4e12c7fbf37)
 
