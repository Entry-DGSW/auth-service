package com.sugang.auth.controller.auth.dto.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class TokenResponse {

    private String token;
    private String name;
    private int accessLevel;
}
