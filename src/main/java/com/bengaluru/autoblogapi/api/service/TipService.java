package com.bengaluru.autoblogapi.api.service;

import org.springframework.http.ResponseEntity;

public interface TipService {
    void doProcess() throws Exception;
    ResponseEntity<String> getTipApi() throws Exception;
    boolean saveFile(String contents);
}
