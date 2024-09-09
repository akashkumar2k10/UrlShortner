package com.example.UrlShortner.Controller;

import java.io.IOException;
import java.security.Key;
import java.util.Optional;

import com.example.UrlShortner.Models.AppUser;
import com.example.UrlShortner.Models.GoogleUser;
import com.example.UrlShortner.Models.Tokens;
import com.example.UrlShortner.Repo.AppUserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "*")
public class AuthController {
    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String clientSecret;


    @Autowired
    AppUserRepo appUserRepo;


    @GetMapping("login")
    public void redirectGoogleOAuth(HttpServletResponse httpServletResponse) throws IOException{
        try{
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://accounts.google.com/o/oauth2/auth")
                    .queryParam("response_type", "code")
                    .queryParam("client_id", clientId)
                    .queryParam("scope", "openid profile email")
                    .queryParam("redirect_uri", "http://localhost:8081/api/getToken");


            String googleAuthUrl = builder.toUriString();
            httpServletResponse.sendRedirect(googleAuthUrl);

        }catch (Exception e){
            e.printStackTrace();

        }

    }


    @GetMapping("getToken")
    public void getToken(@RequestParam("code") String code,HttpServletResponse httpServletResponse) throws IOException {

        String tokenEndpoint = "https://oauth2.googleapis.com/token";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(tokenEndpoint)
            .queryParam("client_id", clientId)
            .queryParam("client_secret", clientSecret)
            .queryParam("code", code)
            .queryParam("grant_type", "authorization_code")
            .queryParam("redirect_uri", "http://localhost:8081/api/getToken"); // Provide your redirect URI

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(builder.toUriString(), null, String.class);
        Tokens token = null;
       try {
            token = new ObjectMapper().readValue(response.getBody(), Tokens.class);
           httpServletResponse.sendRedirect("http://localhost:4200/success?AccessToken="+token.getAccess_token()+"&IdToken="+token.getId_token());
       } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @GetMapping("userInfo")
    public ResponseEntity<GoogleUser> getUserInfo(@RequestParam("access_token") String accessToken) throws JsonMappingException, JsonProcessingException {
        String userInfoEndpoint = "https://www.googleapis.com/oauth2/v2/userinfo";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(userInfoEndpoint)
            .queryParam("access_token", accessToken);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);
        GoogleUser googleUser = new ObjectMapper().readValue(response.getBody(), GoogleUser.class);
        createUser(googleUser);
        return ResponseEntity.ok(googleUser);
    }

    @GetMapping("logout")
    public ResponseEntity<String> logoutUser(@RequestParam("access_token") String accessToken) {
        String revokeTokenEndpoint = "https://oauth2.googleapis.com/revoke";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(revokeTokenEndpoint)
                .queryParam("token", accessToken);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(builder.toUriString(), null, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            // Invalidate the session or clear any application-specific authentication state here.
            return ResponseEntity.ok("User logged out successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to logout user.");
        }
    }


    private AppUser createUser(GoogleUser googleUser) {
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









}
