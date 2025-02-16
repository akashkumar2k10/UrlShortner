package com.example.UrlShortner.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/api/v1/user")
public class UserController {

//    @Autowired
//    UserService userService;

//    @GetMapping("/{id}")
//    public ResponseEntity<AUser> get(@PathVariable Optional<Integer> id) throws Exception {
//        log.info("find all called");
//        return ResponseEntity.ok(userService.get(id).get());
//    }

//    @PostMapping()
//    public ResponseEntity<AUser> save(@RequestBody Optional<AUser> u) throws Exception {
//        log.info("Create user called"+u.toString());
//
//        try {
//            //validate u
//            AUser savedUser = userService.save(u);
//            return ResponseEntity.ok(savedUser);
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().build();
//        }
//    }



}
