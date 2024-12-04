package com.example.UrlShortner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean(name = "keyGenratorWebClient")
    public WebClient keyGenratorWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl("http://localhost:8082/api")
                .build();
    }

    @Bean(name = "serviceBWebClient")
    public WebClient serviceBWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl("http://service-b.com")
                .build();
    }
}
