package com.example.orderSystem.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    //InvalidError
    ORDER_ID_NOT_FOUND(400, "주문 정보가 존재하지 않습니다."),
    INVALID_ORDER_ID(400, "주문 id가 존재하지 않습니다. "),
    DUPLICATE_ORDER_ID(400, "주문 id가 중복됩니다. "),
    INVALID_NAME(400, "주문자 이름이 존재하지 않습니다."),
    INVALID_STATUS(400, "유효하지 않은 주문상태입니다."),
    INVALID_REQUEST_FORMANT(400,"입력 정보가 잘못됐습니다."),


    INVALID_REQUEST_PART(400, "입력 정보가 올바르지 않습니다.");


    private final String message;
    private final int status;

    ErrorCode(final int status, final String message) {
        this.status = status;
        this.message = message;
    }

}
