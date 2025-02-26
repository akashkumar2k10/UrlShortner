package com.example.KeyGenrator.Services;

import com.example.KeyGenrator.Models.FreshKey;
import com.example.KeyGenrator.Models.dto.DtoKey;

import java.net.UnknownHostException;

public interface KeyService {
    public DtoKey getKey() throws UnknownHostException;
}
