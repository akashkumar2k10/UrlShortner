package com.example.UrlShortner.Models.Payload;

import lombok.Data;

@Data
public class ErrorPayload {
    String message;

    public ErrorPayload(String message){
        this.message = message;
    }

}
