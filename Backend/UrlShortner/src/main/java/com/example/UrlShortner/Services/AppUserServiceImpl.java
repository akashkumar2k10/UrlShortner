//package com.example.UrlShortner.Services;
//
//import com.example.UrlShortner.Models.AppUser;
//import com.example.UrlShortner.Repo.AppUserRepo;
//import com.example.UrlShortner.util.CommonUtil;
////import com.example.UrlShortner.util.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AppUserServiceImpl implements AppUserService{
//
//    @Autowired
//    AppUserRepo appUserRepo;
//
//    @Override
//    public Optional<AppUser> get(String email) {
//        if(CommonUtil.ValidateEmail(email)){
//            return appUserRepo.findByEmail(email);
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public Boolean isExist(String email) {
//        if(CommonUtil.ValidateEmail(email)){
//            return appUserRepo.existsByEmail(email);
//        }
//        return false;
//    }
//
//    @Override
//    public AppUser getCurrentUser() {
//        Optional<AppUser> user = get(JwtUtil.getEmail());
//        return user.orElse(null);
//    }
//}
