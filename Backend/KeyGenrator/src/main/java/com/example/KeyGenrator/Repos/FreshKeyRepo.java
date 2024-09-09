package com.example.KeyGenrator.Repos;

import com.example.KeyGenrator.Models.FreshKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreshKeyRepo extends JpaRepository<FreshKey,String> {
    boolean existsByKeyString(String keyString);


    @Query("select keyString from FreshKey where keyString in ?1")
    List<String> getDuplicatekeys(List<String> keys);

    @Query(value = "select * from fresh_key limit 1",nativeQuery = true)
    List<FreshKey> getFreshKeys();

    FreshKey findTopByOrderByGenratedDateDesc();

    @Query("select count(f) from FreshKey f")
    long getLength();

}
