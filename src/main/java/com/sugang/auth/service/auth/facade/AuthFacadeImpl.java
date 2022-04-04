package com.sugang.auth.service.auth.facade;

import com.sugang.auth.controller.auth.dto.request.AuthRequest;
import com.sugang.auth.controller.auth.dto.response.TokenResponse;
import com.sugang.auth.service.auth.DauthAuthService;
import com.sugang.auth.service.auth.QueryDauthLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthFacadeImpl implements AuthFacade {

    private final QueryDauthLinkService queryOauthLinkService;
    private final DauthAuthService dauthAuthService;

    @Override
    public String getQueryDauthLink() {
        return queryOauthLinkService.execute();
    }

    @Override
    public TokenResponse dauthLogin(AuthRequest request) {
        return dauthAuthService.execute(request);
    }

}
