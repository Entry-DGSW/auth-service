package com.sugang.auth.service.auth;

import com.sugang.auth.common.client.api.DauthAuthClient;
import com.sugang.auth.common.client.api.DauthInfoClient;
import com.sugang.auth.common.client.dto.request.DauthCodeRequest;
import com.sugang.auth.common.client.dto.response.DauthInfoResponse.DodamUser;
import com.sugang.auth.common.jwt.JwtProvider;
import com.sugang.auth.config.properties.AuthProperties;
import com.sugang.auth.controller.auth.dto.request.AuthRequest;
import com.sugang.auth.controller.auth.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DauthAuthService {

    private final AuthProperties authProperties;
    private final DauthAuthClient dauthAuthClient;
    private final DauthInfoClient dauthInfoClient;
    private final PublishUserDataService publishUserDataService;
    private final JwtProvider jwtProvider;

    public TokenResponse execute(AuthRequest request) {
        DauthCodeRequest dauthTokenResponse =
                new DauthCodeRequest(request.getCode(), authProperties.getDAuthClientId(), authProperties.getDAuthClientSecret());
        String dauthToken = dauthAuthClient.dauthAuth(dauthTokenResponse).getAccess_token();
        DodamUser dauthInfoResponse = dauthInfoClient.dauthInfo("Bearer " + dauthToken).getData();

        // Kafka 에 데이터 넣기
        publishUserDataService.excute(dauthInfoResponse);

        return new TokenResponse(jwtProvider.generateAccessToken(dauthInfoResponse.getUniqueId(), dauthInfoResponse.getAccessLevel()));
    }
}
