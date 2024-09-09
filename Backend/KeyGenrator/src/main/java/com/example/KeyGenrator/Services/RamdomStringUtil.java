package com.example.KeyGenrator.Services;

import com.example.KeyGenrator.Models.FreshKey;
import com.example.KeyGenrator.Repos.FreshKeyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class RamdomStringUtil {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String DIGITS = "0123456789";
    private static final String ALPHA_NUMERIC = CHAR_LOWER + CHAR_UPPER + DIGITS;

    @Autowired
    FreshKeyRepo freshKeyRepo;

    public static String genrateKeys(Integer count){

        Random r = new Random();

        return r.ints(count,0,ALPHA_NUMERIC.length())
                .mapToObj(ALPHA_NUMERIC::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());

    }

    @Async
    public void genrateFreshKeyAysn(int len){
        genrateFreshKey(len);
    }

    public Boolean genrateFreshKey(int lenght){

        List<String> fkeys = IntStream.range(0,lenght)
                .mapToObj((i)->genrateKeys(6)).distinct().collect(Collectors.toList());
        System.out.println("Size"+fkeys.size());



        fkeys.removeAll(freshKeyRepo.getDuplicatekeys(fkeys));
        fkeys.removeAll(freshKeyRepo.getDuplicatekeys(fkeys));

        List<FreshKey> freshKeyData =  fkeys.stream().map(a -> new FreshKey(a,new Date())).collect(Collectors.toList());
        System.out.println("Size"+fkeys.size());
        freshKeyRepo.saveAll(freshKeyData);


        return false;
    }


}
