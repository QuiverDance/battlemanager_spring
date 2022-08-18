package com.quiverdance.battlemanager.controller;

import com.quiverdance.battlemanager.service.PokemonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PokemonInfoController {
    private final PokemonInfoService pokemonInfoService;

    @Autowired
    public PokemonInfoController(PokemonInfoService pokemonInfoService) {
        this.pokemonInfoService = pokemonInfoService;
    }


}
