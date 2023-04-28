package com.perso.googlebooksapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "api")
@Getter
@Setter
public class GoogleBooksApiConfig {
    private Map<String, String> googleBooks = new HashMap<>();
}
