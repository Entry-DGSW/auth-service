package com.sugang.auth.service.auth;

import com.sugang.auth.config.properties.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryDauthLinkService {

    private static final String DAUTH_QUERY_STRING = "?response_type=code&client_id=%s&state=cioaasukhcsvuihiusadf&redirect_uri=%s";

    private final AuthProperties authProperties;

    public String execute() {
        return authProperties.getDAuthBaseUrl() +
                String.format(DAUTH_QUERY_STRING, authProperties.getDAuthClientId(), authProperties.getDAuthRedirectUrl());
    }
}
