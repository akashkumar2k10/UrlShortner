package com.example.UrlShortner.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FunctionService {

    public String getKey(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8082/api/key";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }


}
