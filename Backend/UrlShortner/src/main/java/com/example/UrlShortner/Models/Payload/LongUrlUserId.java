package com.example.UrlShortner.Models.Payload;

import com.example.UrlShortner.Models.UrlType;
import lombok.Data;

@Data
public class LongUrlUserId {

    Integer id;
    String longUrl;
    String validTill;
    Boolean isDeleted;
    Boolean isDisabled;
    UrlType urlType;
    String customUrl;

}
