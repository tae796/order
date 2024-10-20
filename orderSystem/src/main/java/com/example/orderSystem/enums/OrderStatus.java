package com.example.orderSystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    PROCESSING("처리 중"),
    SHIPPING("배송 중"),
    COMPLETED("완료"),
    CANCELED("취소");

    private final String description;

}
