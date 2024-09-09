package com.example.UrlShortner.Models;

import lombok.Data;
import lombok.Setter;

@Data
public class Tokens {
    public String access_token;
    public int expires_in;
    public String scope;
    public String token_type;
    public String id_token;
}
