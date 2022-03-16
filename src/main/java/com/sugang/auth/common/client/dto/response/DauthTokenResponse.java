package com.sugang.auth.common.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DauthTokenResponse {
    private String access_token;
    private String refresh_token;
    private String token_type;
    private String expires_in;
}
