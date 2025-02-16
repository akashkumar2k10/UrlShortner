package com.example.UrlShortner.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {

//    @Autowired
//    UserRepo userRepo;
    @GetMapping("/")
    public String start(){
        return "Hello world";
    }








}
