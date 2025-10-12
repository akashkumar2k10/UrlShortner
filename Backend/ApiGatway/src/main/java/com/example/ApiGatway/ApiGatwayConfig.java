package com.example.ApiGatway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatwayConfig {
//    @Bean
//    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p->p.path("get")
//                        .uri("https://google.com/"))
//                .route(p -> p.path("KEYGENRATOR/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://KeyGenrator"))
//                .route(p -> p.path("/UrlShortner/**")
//                        .uri("lb://UrlShortner"))
//                .build();
//    }

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("keygenerator_route", r -> r.path("/KEYGENRATOR/**")
                        .filters(f -> f.stripPrefix(1)) // Removes "/KEYGENRATOR" before forwarding
                        .uri("lb://KEYGENRATOR"))
                .route("urlshortner_route", r -> r.path("/URLSHORTNER/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://URLSHORTNER"))
                .build();
    }
}
