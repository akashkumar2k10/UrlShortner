package com.example.UrlShortner.Repo;

import com.example.UrlShortner.Models.MapShortLongUrl;
import com.example.UrlShortner.Models.UrlType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MapShortLongUrlRepo extends JpaRepository<MapShortLongUrl,Integer> {


    @Query("Select longUrl from MapShortLongUrl where shortUrl = ?1")
    Optional<String> findLongUrlByShortUrl(String shortUrl);

    List<MapShortLongUrl> findByUserIdAndUrlType(Integer userId,UrlType urlType);

    @Query("select m from MapShortLongUrl m where shortUrl = ?1 and urlType=?2")
    Optional<MapShortLongUrl> findByShortUrl(String shortUrl, UrlType urlType);

}
