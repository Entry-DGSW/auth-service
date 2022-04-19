package com.sugang.auth.common.jwt;

import com.sugang.auth.common.errors.exception.BaseException;
import com.sugang.auth.common.errors.exception.ErrorCode;
import com.sugang.auth.config.properties.JwtProperties;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

import static com.sugang.auth.common.errors.exception.ErrorCode.*;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtProperties jwtProperties;

    public String generateAccessToken(String userId, int permission) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, getSecretKey())
                .claim("userId", userId)
                .claim("permission", permission)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExp() * 1000))
                .compact();
    }

    public Claims parseToken(String token) throws BaseException {
        try {
            return Jwts.parser()
                    .setSigningKey(getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw BaseException.of(TOKEN_EXPIRE_ERROR);
        } catch (SignatureException | MalformedJwtException e) {
            throw BaseException.of(TOKEN_FORGED_ERROR);
        } catch (IllegalArgumentException e) {
            throw BaseException.of(TOKEN_BAD_REQUEST_ERROR);
        } catch (Exception e) {
            log.error("Token 해석 중 에러 발생! : {}", e.toString());
            throw BaseException.of(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private String getSecretKey() {
        return Base64.getEncoder().encodeToString(jwtProperties.getSecret().getBytes());
    }
}
