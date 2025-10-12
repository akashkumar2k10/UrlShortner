//package com.example.UrlShortner.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.client.WebClient;
//
//@Configuration
//public class WebClientConfig {
//
//    @Value("${KEY_BASE_URL}")
//    String keyGenratorUrl;
//
//    @Bean(name = "keyGenratorWebClient")
//    public WebClient keyGenratorWebClient(WebClient.Builder webClientBuilder) {
//        return webClientBuilder
//                .baseUrl(keyGenratorUrl)
//                .build();
//    }
//
//}
