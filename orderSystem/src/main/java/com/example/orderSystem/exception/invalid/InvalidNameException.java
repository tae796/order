package com.example.orderSystem.exception.invalid;

import com.example.orderSystem.exception.CustomException;
import com.example.orderSystem.exception.ErrorCode;

public class InvalidNameException extends CustomException {
    public InvalidNameException() {
        super(ErrorCode.INVALID_NAME);
    }
}
