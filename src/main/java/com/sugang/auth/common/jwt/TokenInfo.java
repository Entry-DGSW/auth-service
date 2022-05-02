package com.sugang.auth.common.jwt;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class TokenInfo {

    private final String userId;
    private final int permission;
}
