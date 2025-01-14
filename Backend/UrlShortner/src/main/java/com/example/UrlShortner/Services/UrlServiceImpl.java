package com.example.UrlShortner.Services;

import com.example.UrlShortner.Expections.UrlNotFoundException;
import com.example.UrlShortner.Models.AppUser;
import com.example.UrlShortner.Models.MapShortLongUrl;
import com.example.UrlShortner.Models.Payload.LongUrlUserId;
import com.example.UrlShortner.Models.UrlType;
import com.example.UrlShortner.Repo.MapShortLongUrlRepo;
import com.example.UrlShortner.util.CommonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Log4j2
public class UrlServiceImpl implements UrlService{

    @Autowired
    MapShortLongUrlRepo mapShortLongUrlRepo;

    @Autowired
    AppUserService appUserService;

    @Autowired
    ApiService apiService;



    @Override
    public RedirectView getLongUrlByShortId(String shortId,UrlType urlType) throws NoSuchElementException, Exception {
        log.info("Get long URL called for id: {}", shortId);
        MapShortLongUrl map = mapShortLongUrlRepo.findByShortUrl(shortId,urlType)
                .orElseThrow(() -> new UrlNotFoundException("Short URL not found: " + shortId));
        if(map.IsDisabled()){
            log.warn("Short URL is disabled: {}", shortId);
            throw new UrlNotFoundException("This short URL is disabled.");
        }
        return new RedirectView(map.getLongUrl());
    }

    @Override
    public List<MapShortLongUrl> getAllUrlByUser(UrlType urlType) {
        log.info("GET ALL BY USER");
        return mapShortLongUrlRepo.findByUserIdAndUrlType(appUserService.getCurrentUser().getUserId(),urlType);
    }

    @Override
    public MapShortLongUrl createMap(LongUrlUserId longUrlUserId,UrlType urlType) {
        log.info("createMapping : {}", CommonUtil.logPayload(longUrlUserId));
        LocalDate localDate;
        AppUser currentUser = appUserService.getCurrentUser();
        MapShortLongUrl map = new MapShortLongUrl();
        Date d = new Date();
        map.setShortUrl(urlType == UrlType.Custom? longUrlUserId.getCustomUrl() :apiService.getKeys());
        map.setLongUrl(longUrlUserId.getLongUrl());
        map.setUserId(currentUser.getUserId());
        try {
            localDate = LocalDate.parse(longUrlUserId.getValidTill());
            if(localDate.isBefore(LocalDate.now()))
                localDate = LocalDate.now().plusDays(30); //Default

        }catch(Exception e){
            localDate = LocalDate.now().plusDays(30); //Default
        }

        map.setValidTill(localDate);
        map.setUrlType(urlType);
        try{
            return mapShortLongUrlRepo.save(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MapShortLongUrl update(LongUrlUserId longUrlUserId) {
        log.info("Update Mapping : {}", CommonUtil.logPayload(longUrlUserId));

        MapShortLongUrl mapShortLongUrl = null;
        if(longUrlUserId!=null && longUrlUserId.getId()!=null){
            mapShortLongUrl = mapShortLongUrlRepo.getReferenceById(longUrlUserId.getId());

            mapShortLongUrl.setIsDisabled(longUrlUserId.getIsDisabled());

            return mapShortLongUrlRepo.save(mapShortLongUrl);
        }
        throw new UrlNotFoundException("Url not found in the record");
    }

    @Override
    public Boolean delete(Integer id) {
        log.info("Deleting Mapping : {}", CommonUtil.logPayload(id));
        MapShortLongUrl mapShortLongUrl = null;
        if(id!=null){
            mapShortLongUrl = mapShortLongUrlRepo.getReferenceById(id);
            mapShortLongUrlRepo.delete(mapShortLongUrl);
            return true;
        }
        return false;
    }


}
