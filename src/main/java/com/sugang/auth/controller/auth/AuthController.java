package com.sugang.auth.controller.auth;

import com.sugang.auth.service.auth.QueryOauthLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final QueryOauthLinkService queryOauthLinkService;

    @GetMapping("dauth")
    public ResponseEntity<String> getDauthQuery() {
        return ResponseEntity.ok(
                queryOauthLinkService.execute());
    }
}
