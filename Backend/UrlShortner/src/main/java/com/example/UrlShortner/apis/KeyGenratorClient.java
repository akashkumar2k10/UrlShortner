package com.example.UrlShortner.apis;


import com.example.UrlShortner.Models.Payload.DtoKey;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "KeyGenrator", url = "${KEY_BASE_URL:http://localhost:8080}")
public interface KeyGenratorClient {
    @GetMapping("keygenrator/api/key") // Add the correct path
    public DtoKey getkey();
}
