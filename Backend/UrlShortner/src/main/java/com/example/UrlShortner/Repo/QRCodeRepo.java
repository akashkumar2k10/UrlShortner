package com.example.UrlShortner.Repo;

import com.example.UrlShortner.Models.QRCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QRCodeRepo extends JpaRepository<QRCodes,Integer> {


    Optional<QRCodes> findByMapId(Integer mapId);
}
