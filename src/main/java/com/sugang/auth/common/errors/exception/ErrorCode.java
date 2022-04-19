package com.sugang.auth.common.errors.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    DAUTH_BAD_REQUEST_ERROR(400, "DAUTH-400-1", "Dauth server badRequest error occurred"),
    DAUTH_UNAUTHORIZED_ERROR(401, "DAUTH-401-1", "Dauth server unauthorized error occurred"),
    DAUTH_FORBIDDEN_ERROR(403, "DAUTH-403-1", "Dauth server forbidden error occurred"),
    DAUTH_GONE_ERROR(410, "DAUTH-410-1", "Dauth server gone error occurred"),
    DAUTH_SERVER_ERROR(500, "DAUTH-500-1", "Dauth server error occurred"),

    TOKEN_EXPIRE_ERROR(410, "TOKEN-410-1", "Token is expired"),
    TOKEN_FORGED_ERROR(401, "TOKEN-401-1", "Token is forged"),
    TOKEN_BAD_REQUEST_ERROR(400, "TOKEN-400-1", "Token is not avaliable"),

    BAD_REQUEST_ERROR(400, "AUTH-400-1", "Bad Request error occurred"),
    INTERNAL_SERVER_ERROR(500, "AUTH-500-1", "Server error occurred");

    private final int status;
    private final String code;
    private final String message;
}
