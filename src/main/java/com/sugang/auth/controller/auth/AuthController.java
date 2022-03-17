package com.sugang.auth.controller.auth;

import com.sugang.auth.controller.auth.dto.request.AuthRequest;
import com.sugang.auth.controller.auth.dto.response.TokenResponse;
import com.sugang.auth.service.auth.DauthAuthService;
import com.sugang.auth.service.auth.QueryOauthLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final QueryOauthLinkService queryOauthLinkService;
    private final DauthAuthService dauthAuthService;

    @GetMapping("dauth")
    public ResponseEntity<String> getDauthQuery() {
        return ResponseEntity.ok(
                queryOauthLinkService.execute());
    }

    @PutMapping("dauth")
    public ResponseEntity<TokenResponse> getDauthTokenResponse(
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(
                dauthAuthService.execute(request));
    }
}
