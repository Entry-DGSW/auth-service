package com.sugang.auth.common.errors.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException {

    private final int status;

    private final String code;

    private final String message;

    public BaseException(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public static BaseException of(ErrorCode errorCode) {
        return new BaseException(errorCode);
    }
}
