package com.example.UrlShortner.Services;

import com.example.UrlShortner.Models.AppUser;
import com.example.UrlShortner.Models.User;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

public interface AppUserService {

    Optional<AppUser> get(String email);

    Boolean isExist(String email);

    AppUser getCurrentUser();



}
