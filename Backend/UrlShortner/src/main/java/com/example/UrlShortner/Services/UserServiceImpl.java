package com.example.UrlShortner.Services;

import com.example.UrlShortner.Models.User;
import com.example.UrlShortner.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public Optional<User> get(Optional<Integer> id) throws Exception {

        if(id.isPresent()) {
            try {
                return userRepo.findByUserId(id.get());
            }catch (NoSuchElementException e){
                throw new NoSuchElementException(e);
            }catch (Exception e){
                throw e;
            }
        }
        return Optional.empty();
    }
//
    @Override
    public User save(Optional<User> user) throws Exception{
        try {
            if(user.isPresent()) return userRepo.save(user.get());
            else throw new Exception("User body is required");
        }catch (Exception e) {
            System.out.println("Error");
            throw e;
        }
    }
//
//    @Override
//    public Boolean isUser(Optional<Integer> id) {
//        if(id.isPresent()) {
//            return userRepo.existsByUserId(id.get());
//        }
//        return false;
//    }
}
