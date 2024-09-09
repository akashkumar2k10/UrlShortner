package com.example.KeyGenrator.Services;

import com.example.KeyGenrator.Models.FreshKey;
import com.example.KeyGenrator.Models.UsedKey;
import com.example.KeyGenrator.Models.dto.DtoKey;
import com.example.KeyGenrator.Repos.FreshKeyRepo;
import com.example.KeyGenrator.Repos.UsedKeyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class KeyServiceImpl implements KeyService{

    @Autowired
    FreshKeyRepo freshKeyRepo;
    @Autowired
    RamdomStringUtil ramdomStringUtil;

    @Autowired
    UsedKeyRepo usedKeyRepo;

    @Override
    public DtoKey getKey() {
        long count = freshKeyRepo.getLength();
        if (count == 0) ramdomStringUtil.genrateFreshKey(10);
        else if (count < 20) ramdomStringUtil.genrateFreshKeyAysn(40);
        FreshKey fk = freshKeyRepo.findTopByOrderByGenratedDateDesc();
        freshKeyRepo.delete(fk);
        usedKeyRepo.save(new UsedKey(fk.getKeyString(),new Date()));
        return new DtoKey(fk.getKeyString());
    }
}
