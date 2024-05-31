package com.api_rest.rest_client.service;

import com.api_rest.rest_client.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MarvelService {
    LogService logService;

    //dependency service
    Object apiMarvelService;

    @Autowired
    MarvelService(LogService logService/*, Object apiMarvelService*/) {
        this.logService = logService;
        //this.apiMarvelService = apiMarvelService;
    }

    public List findAllCharacters() {
        Log log = new Log();
        log.setEndpoint("findAllCharacters");
        log.setDate(new Date());

        logService.saveLog(log);
        return new ArrayList();
    }

    public Object findCharacterById(Long id) {
        Log log = new Log();
        log.setEndpoint("findCharacterById");
        log.setDate(new Date());

        logService.saveLog(log);
        return new Object();
    }
}
