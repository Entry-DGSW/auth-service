package com.sugang.auth.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties("auth")
public class AuthProperties {

    private OAuth dauth;

    @Getter
    @Setter
    public static class OAuth {
        private String baseUrl;
        private String clientId;
        private String clientSecret;
        private String redirectUrl;
    }

    public String getDAuthBaseUrl() {
        return dauth.getBaseUrl();
    }

    public String getDAuthClientId() {
        return dauth.getClientId();
    }

    public String getDAuthClientSecret() {
        return dauth.getClientSecret();
    }

    public String getDAuthRedirectUrl() {
        return dauth.getRedirectUrl();
    }
}
