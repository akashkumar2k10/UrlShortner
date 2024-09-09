package com.example.KeyGenrator.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class FreshKey {

    @Id @NonNull String keyString;
    @NonNull Date genratedDate;

}
