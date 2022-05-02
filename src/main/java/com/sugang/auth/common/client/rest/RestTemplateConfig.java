package com.sugang.auth.common.client.rest;

import lombok.Builder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@Builder
public class RestTemplateConfig {

    private final RestTemplateBuilder restTemplateBuilder;

    private final String DODAM_AUTH = "http://dauth.b1nd.com/api";
    private final String DODAM_OPENAPI = "http://open.dodam.b1nd.com/api";

    private RestTemplate restTemplate(final String endpoint) {
        return restTemplateBuilder.rootUri(endpoint)
                .additionalInterceptors(new RestTemplateClientHttpRequestInterceptor())
                .errorHandler(new RestTemplateErrorHandler())
                .setConnectTimeout(Duration.ofMinutes(3))
                .build();
    }

    @Bean
    public RestTemplate dodamAuthTemplate() {
        return this.restTemplate(DODAM_AUTH);
    }

    @Bean
    public RestTemplate dodamOpenTemplate() {
        return this.restTemplate(DODAM_OPENAPI);
    }
}
