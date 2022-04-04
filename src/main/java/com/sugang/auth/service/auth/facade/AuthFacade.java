package com.sugang.auth.service.auth.facade;

import com.sugang.auth.controller.auth.dto.request.AuthRequest;
import com.sugang.auth.controller.auth.dto.response.TokenResponse;

public interface AuthFacade {

    String getQueryDauthLink();

    TokenResponse dauthLogin(AuthRequest request);
}
