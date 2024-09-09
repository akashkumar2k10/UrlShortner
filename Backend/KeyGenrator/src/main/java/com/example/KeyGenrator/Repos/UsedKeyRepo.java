package com.example.KeyGenrator.Repos;

import com.example.KeyGenrator.Models.FreshKey;
import com.example.KeyGenrator.Models.UsedKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsedKeyRepo extends JpaRepository<UsedKey,String> {
    boolean existsByKeyString(String keyString);


    @Query("select keyString from UsedKey where keyString in ?1")
    List<String> getDuplicatekeys(List<String> keys);

    @Query("select u from UsedKey u")
    UsedKey get();

}
