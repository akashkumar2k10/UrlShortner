package com.example.UrlShortner.Services;

import com.example.UrlShortner.Models.Payload.DtoKey;
import com.example.UrlShortner.apis.KeyGenratorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiFeginServiceImpl implements ApiService{

    @Autowired
    KeyGenratorClient keyGenratorClient;

    @Override
    public String getKeys() {
       DtoKey key =  keyGenratorClient.getkey();
       return key.getKey();
    }
}
