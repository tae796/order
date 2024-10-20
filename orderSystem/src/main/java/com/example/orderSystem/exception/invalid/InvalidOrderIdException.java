package com.example.orderSystem.exception.invalid;

import com.example.orderSystem.exception.CustomException;
import com.example.orderSystem.exception.ErrorCode;

public class InvalidOrderIdException extends CustomException {
    public InvalidOrderIdException() {
        super(ErrorCode.INVALID_ORDER_ID);
    }
}
