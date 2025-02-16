package com.example.UrlShortner.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
public class AUser {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    @NonNull String userName;
    @NonNull String age;
    Gender gender;
    @NonNull private Boolean isAdmin;
}
