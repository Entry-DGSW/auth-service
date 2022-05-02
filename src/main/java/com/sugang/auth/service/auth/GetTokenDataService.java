package com.sugang.auth.service.auth;

import com.sugang.auth.common.jwt.JwtProvider;
import com.sugang.auth.common.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTokenDataService {

    private final JwtProvider jwtProvider;

    public TokenInfo execute(String token) {
        return jwtProvider.parseTokenData(token);
    }
}
