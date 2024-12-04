package com.example.UrlShortner.Services;

import com.example.UrlShortner.Models.AppUser;
import com.example.UrlShortner.Models.GoogleUser;

public interface AuthService {
    AppUser createUser(GoogleUser googleUser);
    Boolean logout(String token);

    AppUser getUser(String token);

    String getToken(String code);

}
