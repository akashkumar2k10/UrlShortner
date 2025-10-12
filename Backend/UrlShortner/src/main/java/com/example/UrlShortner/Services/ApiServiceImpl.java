package com.example.UrlShortner.Services;

import com.example.UrlShortner.Models.Payload.PayloadKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

//@Service
public class ApiServiceImpl implements ApiService{
    @Autowired
//    @Qualifier("keyGenratorWebClient")
    private WebClient keyGenratorWebClient;
    @Override
    public String getKeys() {

        try {
            Mono<PayloadKey> response = keyGenratorWebClient.get()
                    .uri("/key")
                    .retrieve()
                    .bodyToMono(PayloadKey.class)
                    .onErrorResume(e -> {
                        System.err.println("Error occurred while fetching keys: " + e.getMessage());
                        throw new RuntimeException("Not able to connect with KeyGenrator Upper");
                    });

            // Make sure to handle potential null from block()
            PayloadKey payloadKey = response.block();
            if(payloadKey != null) return payloadKey.getKey(); // Provide a default value if the key is null

        } catch (Exception e) {
            // Catch other synchronous exceptions
            System.err.println("Exception occurred: " + e.getMessage());
            throw new RuntimeException("Not able to connect with KeyGenrator Lower");
        }
        return null;
    }
}
