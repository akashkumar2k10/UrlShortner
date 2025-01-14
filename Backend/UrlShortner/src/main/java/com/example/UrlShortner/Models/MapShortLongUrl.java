package com.example.UrlShortner.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MapShortLongUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NonNull
    @Column(length = 5000)
    String longUrl;

    @NonNull
    String shortUrl;

    @NonNull
    Integer userId;

    Boolean isDisabled = Boolean.FALSE;
    LocalDate validTill;
    UrlType urlType;

    public Boolean IsDisabled() {
        if (isDisabled)
            return true;
        return validTill.isBefore(LocalDate.now());

    }
}
