package com.example.UrlShortner.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    @NonNull String userName;
    @NonNull String age;
    Gender gender;
    @NonNull private boolean isAdmin;





    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                ", gender=" + gender +
                '}';
    }
}
