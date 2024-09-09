package com.example.UrlShortner.Repo;

import com.example.UrlShortner.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Predicate;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findByUserId(Integer userId);

    Boolean existsByUserId(Integer userId);
}
