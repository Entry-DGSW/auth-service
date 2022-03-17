package com.sugang.auth.common.client;

import com.sugang.auth.common.errors.exception.BaseException;
import com.sugang.auth.common.errors.exception.ErrorCode;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        if (response.status() >= 400) {
            switch (response.status()) {
                case 400:
                    throw new BaseException(ErrorCode.DAUTH_BAD_REQUEST_ERROR);
                case 401:
                    throw new BaseException(ErrorCode.DAUTH_UNAUTHORIZED_ERROR);
                case 403:
                    throw new BaseException(ErrorCode.DAUTH_FORBIDDEN_ERROR);
                case 410:
                    throw new BaseException(ErrorCode.DAUTH_GONE_ERROR);
                default:
                    throw new BaseException(ErrorCode.DAUTH_SERVER_ERROR);
            }
        }

        return FeignException.errorStatus(methodKey, response);
    }

}

