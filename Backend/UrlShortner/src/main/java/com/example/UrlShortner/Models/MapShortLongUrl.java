package com.example.UrlShortner.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MapShortLongUrl {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NonNull @Column(length = 5000)
    String longUrl;

    @NonNull
    String shortUrl;


    @NonNull
    Integer userId;

    Boolean isDisabled=Boolean.FALSE;
}
