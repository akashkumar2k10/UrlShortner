package com.example.UrlShortner.Services;

import com.example.UrlShortner.Models.AppUser;
import com.example.UrlShortner.Models.GoogleUser;
import com.example.UrlShortner.Repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AuthServiceImpl implements AuthService{

    @Autowired
    AppUserRepo appUserRepo;
    @Override
    public AppUser createUser(GoogleUser googleUser) {
        Optional<AppUser> user = appUserRepo.findByEmail(googleUser.getEmail());
        if(user.isEmpty()){
            AppUser appUser = new AppUser();
            appUser.setName(googleUser.getName());
            appUser.setEmail(googleUser.getEmail());
            appUser.setPicture(googleUser.getPicture());
            appUser.setFamily_name(googleUser.getFamily_name());
            appUser.setIsAdmin(false);
            appUser.setGiven_name(googleUser.getGiven_name());
            return appUserRepo.save(appUser);
        }
        return user.get();
    }

    @Override
    public Boolean logout(String token) {
        return null;
    }

    @Override
    public AppUser getUser(String token) {
        return null;
    }

    @Override
    public String getToken(String code) {
        return null;
    }
}
