package com.sugang.auth.common.errors;

import com.sugang.auth.common.errors.exception.BaseException;
import com.sugang.auth.common.errors.exception.ErrorCode;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private final int status;
    private final String code;
    private final String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public static ErrorResponse of(ErrorCode errorCode) {
        return new ErrorResponse(errorCode);
    }

    public static ErrorResponse of(BaseException baseException) {
        return new ErrorResponse(baseException.getStatus(), baseException.getCode(), baseException.getMessage());
    }
}
