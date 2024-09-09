package com.example.UrlShortner.Models;

import lombok.Data;

@Data
public class GoogleUser {
        public String id;
        public String email;
        public boolean verified_email;
        public String name;
        public String given_name;
        public String family_name;
        public String picture;
        public String locale;
}
