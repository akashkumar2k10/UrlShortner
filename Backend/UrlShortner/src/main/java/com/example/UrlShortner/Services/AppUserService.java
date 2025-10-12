package com.example.UrlShortner.Services;

import com.example.UrlShortner.Models.AppUser;

import java.util.Optional;

public interface AppUserService {

    Optional<AppUser> get(String email);

    Boolean isExist(String email);

    AppUser getCurrentUser();

}
