package com.example.UrlShortner.Models.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class PayloadUser {
    String uname;
    String password;
}
