package com.example.orderSystem.exception.invalid;

import com.example.orderSystem.exception.CustomException;
import com.example.orderSystem.exception.ErrorCode;

public class InvalidRequestFormatException extends CustomException {
    public InvalidRequestFormatException() {
        super(ErrorCode.INVALID_REQUEST_FORMANT);
    }
}
