package com.example.UrlShortner.Services;

import com.example.UrlShortner.Models.AppUser;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class AppUserServiceImplTemp implements AppUserService{

    @Override
    public Optional<AppUser> get(String email) {
        return Optional.empty();
    }

    @Override
    public Boolean isExist(String email) {
        return null;
    }

    @Override
    public AppUser getCurrentUser() {
        AppUser appUser = new AppUser();
        appUser.setUserId(1);
        appUser.setEmail("akashkumar2k10@gmail.com");

        return appUser;
    }
}
