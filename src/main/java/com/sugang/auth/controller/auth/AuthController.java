package com.sugang.auth.controller.auth;

import com.sugang.auth.common.jwt.TokenInfo;
import com.sugang.auth.controller.auth.dto.request.AuthRequest;
import com.sugang.auth.controller.auth.dto.response.TokenResponse;
import com.sugang.auth.service.auth.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth-service")
@RequiredArgsConstructor
public class AuthController {

    private final AuthFacade authFacade;

    @GetMapping("dauth")
    public ResponseEntity<String> getDauthQuery() {
        return ResponseEntity.ok(
                authFacade.getQueryDauthLink());
    }

    @PutMapping("dauth")
    public ResponseEntity<TokenResponse> getDauthTokenResponse(
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(
                authFacade.dauthLogin(request));
    }

    @GetMapping("dauth")
    public ResponseEntity<TokenInfo> getTokenParse(
            @RequestHeader("authorization") String token
    ) {
        return ResponseEntity.ok(
                authFacade.getTokenInfo(token));
    }
}
