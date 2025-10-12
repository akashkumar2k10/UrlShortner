package com.example.UrlShortner.apis;


import com.example.UrlShortner.Models.Payload.DtoKey;
import com.example.UrlShortner.config.FeignTracingConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "keygenrator", url = "${KEY_BASE_URL:http://localhost:8083}",configuration = FeignTracingConfig.class)
public interface KeyGenratorClient {
    @GetMapping("/keygenrator/api/key")
    public DtoKey getkey();
}
