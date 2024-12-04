package com.example.UrlShortner.Controller;

import com.example.UrlShortner.Repo.MapShortLongUrlRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@Log4j2
@RequestMapping("s")
public class ShortUrl {

    String ErrorPage = "http://localhost:4200/error";

    @Autowired
    MapShortLongUrlRepo mapShortLongUrlRepo;

    @GetMapping("/{id}")
    public RedirectView getLongUrl(@PathVariable("id") String id){
        log.info("Get long url called");
        Optional<String> ans = mapShortLongUrlRepo.findLongUrlByShortUrl(id);
        return ans.map(RedirectView::new).orElseGet(() -> new RedirectView(ErrorPage));
    }


}
