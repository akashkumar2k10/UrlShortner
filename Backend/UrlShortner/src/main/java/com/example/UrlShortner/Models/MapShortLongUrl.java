package com.example.UrlShortner.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MapShortLongUrl {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NonNull
    String longUrl;

    @NonNull
    String shortUrl;

    @NonNull
    Integer userId;

}
