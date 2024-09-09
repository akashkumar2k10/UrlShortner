package com.example.UrlShortner.Controller;

import com.example.UrlShortner.Models.MapShortLongUrl;
import com.example.UrlShortner.Models.Payload.LongUrlUserId;
import com.example.UrlShortner.Repo.MapShortLongUrlRepo;
import com.example.UrlShortner.Services.FunctionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
@RequestMapping("/url")
public class UrlController {


    @Autowired
    MapShortLongUrlRepo mapShortLongUrlRepo;

    @Autowired
    FunctionService functionService;

    @GetMapping("/{id}")
    public RedirectView getLongUrl(@PathVariable("id") String id){
        log.info("Get long url called");
        Optional<String> ans = mapShortLongUrlRepo.findLongUrlByShortUrl(id);
        return ans.map(RedirectView::new).orElse(null);
    }

    @GetMapping
    public List<MapShortLongUrl> getAll(){
        log.info("get all called");
        return mapShortLongUrlRepo.findAll();
    }

    @PostMapping
    public MapShortLongUrl createMapping(@RequestBody LongUrlUserId longUrlUserId){
        log.info("createMapping");
        MapShortLongUrl map = new MapShortLongUrl();
        Date d = new Date();
        map.setShortUrl(functionService.getKey());
        map.setLongUrl(longUrlUserId.getLongUrl());
        map.setUserId(longUrlUserId.getUserId());

        try{
            return mapShortLongUrlRepo.save(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
