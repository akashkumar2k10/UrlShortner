package com.example.KeyGenrator.Controller;

import com.example.KeyGenrator.Models.FreshKey;
import com.example.KeyGenrator.Models.UsedKey;
import com.example.KeyGenrator.Models.dto.DtoKey;
import com.example.KeyGenrator.Repos.FreshKeyRepo;
import com.example.KeyGenrator.Repos.UsedKeyRepo;
import com.example.KeyGenrator.Services.KeyService;
import com.example.KeyGenrator.Services.RamdomStringUtil;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/key",produces = MediaType.APPLICATION_JSON_VALUE)
@Log4j2
public class KeyGenratorController {
    @Autowired
    private FreshKeyRepo freshKeyRepo;

    @Autowired
    private UsedKeyRepo usedKeyRepo;


    @Autowired
    RamdomStringUtil ramdomStringUtil;

    @Autowired
    KeyService keyService;

    @GetMapping
    public DtoKey getkey(){
        log.info("GET KEY");
        return keyService.getKey();
    }


    @PostMapping("{id}")
    public boolean getrateFreshkeys(@PathVariable("id") Integer id){
        return ramdomStringUtil.genrateFreshKey(id);
    }





}
