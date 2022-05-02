package com.sugang.auth.service.auth.facade;

import com.sugang.auth.controller.auth.dto.request.AuthRequest;
import com.sugang.auth.controller.auth.dto.response.TokenResponse;
import com.sugang.auth.service.auth.DAuthRestTemplatService;
import com.sugang.auth.service.auth.QueryDauthLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthFacadeImpl implements AuthFacade {

    private final QueryDauthLinkService queryOauthLinkService;
    // @deprecated by feign client
//    private final DauthAuthService dauthAuthService;
    private final DAuthRestTemplatService dAuthRestTemplatService;

    @Override
    public String getQueryDauthLink() {
        return queryOauthLinkService.execute();
    }

    @Override
    public TokenResponse dauthLogin(AuthRequest request) {
//        return dauthAuthService.execute(request);
        return dAuthRestTemplatService.execute(request.getCode());
    }

}
