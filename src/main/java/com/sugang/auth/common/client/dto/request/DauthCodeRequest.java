package com.sugang.auth.common.client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DauthCodeRequest {

    private String code;
    private String client_id;
    private String client_secret;
}
