package com.example.UrlShortner.ControllerAdvise;

import com.example.UrlShortner.Expections.UrlNotFoundException;
import com.example.UrlShortner.Models.Payload.ErrorPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UrlExceptionHandler {
    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<ErrorPayload> handleUrlNotFoundExpection(UrlNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorPayload(ex.getMessage()));
    }

}
