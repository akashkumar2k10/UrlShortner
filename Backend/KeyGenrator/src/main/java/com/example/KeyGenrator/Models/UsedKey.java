package com.example.KeyGenrator.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UsedKey {
    @Id @NonNull String keyString;
    @NonNull Date usedDate;
}
