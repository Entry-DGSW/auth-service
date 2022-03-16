package com.sugang.auth.common.client.api;

import com.sugang.auth.common.client.dto.request.DauthCodeRequest;
import com.sugang.auth.common.client.dto.response.DauthTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "dauthToken", url = "http://dauth.b1nd.com/api/token")
public interface DauthAuthClient {

    @PostMapping
    DauthTokenResponse dauthAuth(DauthCodeRequest request);
}
