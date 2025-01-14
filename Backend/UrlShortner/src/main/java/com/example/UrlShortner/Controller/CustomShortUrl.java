package com.example.UrlShortner.Controller;

import com.example.UrlShortner.Models.UrlType;
import com.example.UrlShortner.Services.UrlService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Log4j2
@RequestMapping("/c")
public class CustomShortUrl {

    String ErrorPage = "http://localhost:4200/error";

    @Autowired
    UrlService urlService;

    @GetMapping("/{id}")
    public RedirectView getLongUrl(@PathVariable("id") String id) throws Exception {
        return urlService.getLongUrlByShortId(id, UrlType.Custom);
    }

}
