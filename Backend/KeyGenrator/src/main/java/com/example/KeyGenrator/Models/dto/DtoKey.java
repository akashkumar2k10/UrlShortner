package com.example.KeyGenrator.Models.dto;

public class DtoKey {
    String key;
    String host;
    public DtoKey() {
    }

    public DtoKey(String key,String host){
        this.key = key;
        this.host = host;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }
}
