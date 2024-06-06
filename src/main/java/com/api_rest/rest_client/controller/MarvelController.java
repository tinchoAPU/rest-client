package com.api_rest.rest_client.controller;


import com.api_rest.rest_client.service.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marvel")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/harcoded")
    public Object getCharacterByIdHarcoded() {
        return marvelService.findCharacterByIdHarcoded();
    }
}
