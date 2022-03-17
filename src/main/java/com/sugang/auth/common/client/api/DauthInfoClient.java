package com.sugang.auth.common.client.api;

import com.sugang.auth.common.client.dto.response.DauthInfoResponse;
import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "dauthInfo", url = "http://open.dodam.b1nd.com/api/user")
public interface DauthInfoClient {

    @GetMapping
    DauthInfoResponse dauthInfo(@RequestHeader("Authorization") String authorization);

}
