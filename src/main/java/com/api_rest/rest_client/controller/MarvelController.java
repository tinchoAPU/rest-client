package com.api_rest.rest_client.controller;


import com.api_rest.rest_client.service.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marvel")
public class MarvelController {

    MarvelService marvelService;

    @Autowired
    MarvelController(MarvelService marvelService) {
        this.marvelService = marvelService;
    }

    @GetMapping
    List getAllCharacters() {
        return marvelService.findAllCharacters();
    }

    @GetMapping("/{characterId}")
    public Object getCharacterById(@PathVariable("characterId") Long characterId) {
        return marvelService.findCharacterById(characterId);
    }
}
