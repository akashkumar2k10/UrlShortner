package com.example.UrlShortner.Controller;

import com.example.UrlShortner.Models.MapShortLongUrl;
import com.example.UrlShortner.Models.Payload.LongUrlUserId;
import com.example.UrlShortner.Models.UrlType;
import com.example.UrlShortner.Services.UrlService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("api/custom/url")
@CrossOrigin(origins = "*")
public class CustomLinkController {
    @Autowired
    UrlService urlService;

    @GetMapping
    public List<MapShortLongUrl> getAll() {
        log.info("GET ALL BY USER");
        return urlService.getAllUrlByUser(UrlType.Custom);
    }

    @PostMapping
    public MapShortLongUrl createMapping(@RequestBody LongUrlUserId longUrlUserId) {
        return urlService.createMap(longUrlUserId, UrlType.Custom);
    }

    @PutMapping
    public MapShortLongUrl update(@RequestBody LongUrlUserId longUrlUserId) {
        return urlService.update(longUrlUserId);
    }

    @PostMapping("delete/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return urlService.delete(id);
    }

}
