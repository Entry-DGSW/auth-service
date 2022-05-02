package com.sugang.auth.service.auth;

import com.sugang.auth.common.client.dto.request.DauthCodeRequest;
import com.sugang.auth.common.client.dto.response.DauthInfoResponse;
import com.sugang.auth.common.client.dto.response.DauthInfoResponse.DodamUser;
import com.sugang.auth.common.client.dto.response.DauthTokenResponse;
import com.sugang.auth.common.client.rest.RestTemplateConfig;
import com.sugang.auth.common.jwt.JwtProvider;
import com.sugang.auth.config.properties.AuthProperties;
import com.sugang.auth.controller.auth.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Objects;


@Service
@Slf4j
@RequiredArgsConstructor
public class DAuthRestTemplatService {

    private final RestTemplateConfig restTemplateConfig;
    private final AuthProperties authProperties;
    private final PublishUserDataService publishUserDataService;
    private final JwtProvider jwtProvider;

    public TokenResponse execute(String code) {
        DodamUser dodamUser = getCodeToDodamInfo(code);

        // Kafka 에 데이터 넣기
        publishUserDataService.excute(dodamUser);

        return new TokenResponse(
                jwtProvider.generateAccessToken(
                        dodamUser.getUniqueId(), dodamUser.getAccessLevel()), dodamUser.getName(), dodamUser.getAccessLevel());
    }

    private DauthTokenResponse getDAuthToken(@NotNull String code) {
        log.info("--------dauth Server request--------");
        return restTemplateConfig.dodamAuthTemplate().postForObject(
                "/token", new HttpEntity<>(DauthCodeRequest.builder().code(code).client_id(authProperties.getDAuthClientId()).client_secret(authProperties.getDAuthClientSecret()).build(), null
                ), DauthTokenResponse.class);
    }

    private DodamUser getCodeToDodamInfo(final String code) {
        log.info("--------dodam Server request--------");
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", "Bearer " + getDAuthToken(code).getAccess_token());
        return Objects.requireNonNull(
                restTemplateConfig.dodamOpenTemplate().exchange(
                        "/user", HttpMethod.GET, new HttpEntity<>(headers), DauthInfoResponse.class
                ).getBody()).getData();
    }
}
