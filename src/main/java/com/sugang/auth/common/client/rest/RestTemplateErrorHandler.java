package com.sugang.auth.common.client.rest;

import com.sugang.auth.common.errors.exception.BaseException;
import io.micrometer.core.lang.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.*;

@Slf4j
public class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {

        final HttpStatus status = response.getStatusCode();
        return !status.is2xxSuccessful();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        final String error = getErrorAsString(response);
        log.error("Headers: {}", response.getHeaders());
        log.error("Response failed : {}", error);

        throw new BaseException(response.getStatusCode().value(), "REST-ERROR", response.getStatusText());
    }

    private String getErrorAsString(@NonNull final ClientHttpResponse response) throws IOException {
        try (
                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(response.getBody())))
        ) {
            return bufferedReader.readLine();
        }
    }
}

