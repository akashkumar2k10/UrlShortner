package com.example.UrlShortner.Services;

import com.example.UrlShortner.Models.User;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

public interface UserService {
    public Optional<User> get(Optional<Integer> id) throws Exception;

    public User save(Optional<User> User) throws Exception;

//    public Boolean isUser(Optional<Integer> id) throws Exception;public Optional<User> save(Optional<User> User) throws Exception;
//
//    public Boolean isUser(Optional<Integer> id) throws Exception;

}
