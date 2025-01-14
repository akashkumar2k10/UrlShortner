package com.example.UrlShortner.Services;

import com.example.UrlShortner.Models.MapShortLongUrl;
import com.example.UrlShortner.Models.Payload.LongUrlUserId;
import com.example.UrlShortner.Models.UrlType;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.NoSuchElementException;

public interface UrlService {

    RedirectView getLongUrlByShortId(String shortId, UrlType urlType) throws NoSuchElementException,Exception;
    List<MapShortLongUrl> getAllUrlByUser(UrlType urlType);

    MapShortLongUrl createMap(LongUrlUserId longUrlUserId,UrlType urlType);

    MapShortLongUrl update(LongUrlUserId longUrlUserId);

    Boolean delete(Integer id);
}
