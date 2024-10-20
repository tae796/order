package com.example.orderSystem.exception.invalid;

import com.example.orderSystem.exception.CustomException;
import com.example.orderSystem.exception.ErrorCode;

public class OrderNotFoundException extends CustomException {
    public OrderNotFoundException() {
        super(ErrorCode.ORDER_ID_NOT_FOUND);
    }
}
