package com.sugang.auth.common.errors.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException {

    private final ErrorCode errorCode;

    public int getStatus() {
        return errorCode.getStatus();
    }

    public String getCode() {
        return errorCode.getCode();
    }

    public String getMessage() {
        return errorCode.getMessage();
    }
}
