package com.example.UrlShortner.Services;

import com.example.UrlShortner.Models.Fib;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FunctionService {

    public String getKey(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8082/key";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }


}
