package com.example.orderSystem.exception.invalid;

import com.example.orderSystem.exception.CustomException;
import com.example.orderSystem.exception.ErrorCode;

public class DuplicateOrderIdException extends CustomException {
    public DuplicateOrderIdException() {
        super(ErrorCode.DUPLICATE_ORDER_ID);
    }
}
