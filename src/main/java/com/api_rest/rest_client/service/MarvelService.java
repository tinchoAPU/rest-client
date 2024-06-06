package com.api_rest.rest_client.service;

import com.api_rest.rest_client.entity.Log;
import com.fullstack.marvel_api_client.apiClient.MarvenApiClient;
import com.fullstack.marvel_api_client.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarvelService {
    private LogService logService;

    private MarvenApiClient apiMarvelService;

    static final String FIND_ONE_SERVICE = "findCharacterById";
    static final String FIND_ALL_SERVICE = "findAllCharacters";

    @Autowired
    MarvelService(LogService logService) {
        this.logService = logService;
        this.apiMarvelService = new MarvenApiClient();
    }

    public List<CharacterDTO> findAllCharacters() {
        List<CharacterDTO> characters = apiMarvelService.getAllCharacters();
        logService.saveLog(new Log(new Date(), FIND_ALL_SERVICE));
        return characters;
    }

    public CharacterDTO findCharacterById(Long id) {
        CharacterDTO character = apiMarvelService.getCharacterById(id);
        logService.saveLog(new Log(new Date(), FIND_ONE_SERVICE));
        return character;
    }

    public CharacterDTO findCharacterByIdHarcoded() {
        CharacterDTO character = apiMarvelService.getCharacterByIdHarcoded();
        logService.saveLog(new Log(new Date(), FIND_ONE_SERVICE));
        return character;
    }

}
