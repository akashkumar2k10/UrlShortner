package com.example.UrlShortner.Controller;

import com.example.UrlShortner.Models.Gender;
import com.example.UrlShortner.Models.Payload.PayloadUser;
import com.example.UrlShortner.Models.User;
import com.example.UrlShortner.Repo.UserRepo;
import com.example.UrlShortner.Services.UserService;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Optional<Integer> id) throws Exception {
        log.info("find all called");
        return ResponseEntity.ok(userService.get(id).get());
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody Optional<User> u) throws Exception {
        log.info("Create user called"+u.toString());

        try {
            //validate u
            User savedUser = userService.save(u);
            return ResponseEntity.ok(savedUser);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }




    }
//
//
//    @GetMapping()
//    public Gender[] getAllGender(){
//        log.info("gender called");
//        return Gender.values();
//    }



}
