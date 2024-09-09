package com.example.UrlShortner.Repo;

import com.example.UrlShortner.Models.MapShortLongUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MapShortLongUrlRepo extends JpaRepository<MapShortLongUrl,Integer> {


    @Query("Select longUrl from MapShortLongUrl where shortUrl = ?1")
    Optional<String> findLongUrlByShortUrl(String shortUrl);

}
