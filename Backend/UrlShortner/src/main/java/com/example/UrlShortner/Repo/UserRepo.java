package com.example.UrlShortner.Repo;

import com.example.UrlShortner.Models.AUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<AUser,Integer> {

    Optional<AUser> findByUserId(Integer userId);

    Boolean existsByUserId(Integer userId);

}
