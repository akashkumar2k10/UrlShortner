package com.example.UrlShortner.Controller;

import com.example.UrlShortner.Models.User;
import com.example.UrlShortner.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StartController {

    @Autowired
    UserRepo userRepo;
    @GetMapping("/")
    public String start(){
        return "Hello world";
    }








}
