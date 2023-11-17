package com.perso.booksapi.config;

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
public class BooksApiConfig {
    private Map<String, String> googleBooks = new HashMap<>();
}
