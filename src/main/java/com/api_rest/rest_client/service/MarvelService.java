package com.api_rest.rest_client.service;

import com.api_rest.rest_client.entity.Log;
import com.fullstack.marvel_api_client.apiClient.MarvenApiClient;
import com.fullstack.marvel_api_client.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MarvelService {
    LogService logService;

    MarvenApiClient apiMarvelService;

    @Autowired
    MarvelService(LogService logService) {
        this.logService = logService;
        this.apiMarvelService = new MarvenApiClient();
    }

    public List<CharacterDTO> findAllCharacters() {
        Log log = new Log();
        log.setEndpoint("findAllCharacters");
        log.setDate(new Date());
        List<CharacterDTO> characters = apiMarvelService.getAllCharacters();
        logService.saveLog(log);
        return characters;
    }

    public CharacterDTO findCharacterById(Long id) {
        Log log = new Log();
        log.setEndpoint("findCharacterById");
        log.setDate(new Date());

        CharacterDTO character = apiMarvelService.getCharacterById(id);
        logService.saveLog(log);
        return character;
    }
}
