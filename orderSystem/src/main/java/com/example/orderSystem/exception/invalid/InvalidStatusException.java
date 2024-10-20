package com.example.orderSystem.exception.invalid;

import com.example.orderSystem.exception.CustomException;
import com.example.orderSystem.exception.ErrorCode;

public class InvalidStatusException extends CustomException {
    public InvalidStatusException() {
        super(ErrorCode.INVALID_STATUS);
    }
}
