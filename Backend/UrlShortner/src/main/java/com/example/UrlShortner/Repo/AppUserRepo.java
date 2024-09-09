package com.example.UrlShortner.Repo;

import com.example.UrlShortner.Models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Integer> {

    boolean existsByEmail(String email);


    Optional<AppUser> findByEmail(String email);
}
