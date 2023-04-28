package com.perso.googlebooksapi.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
@ConditionalOnBean(GoogleBooksApiConfig.class)
public class WebClientConfig {
    @Bean
    public WebClient getWebClient() {
    return WebClient.builder()
            .baseUrl("https://www.googleapis.com/books/v1")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
    }
}
