package com.quiverdance.battlemanager.controller;

import com.quiverdance.battlemanager.domain.PokemonInfo;
import com.quiverdance.battlemanager.service.PokemonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PokemonInfoController {
    private final PokemonInfoService pokemonInfoService;

    @Autowired
    public PokemonInfoController(PokemonInfoService pokemonInfoService) {
        this.pokemonInfoService = pokemonInfoService;
    }

    @GetMapping("/pokemon/all")
    public ResponseEntity<?> getPokemonList(){
        return new ResponseEntity<>(pokemonInfoService.findAllPokemonInfo(), HttpStatus.OK);
    }

    @GetMapping("/pokemon/all/name")
    public ResponseEntity<?> getPokemonNameList(){
        List<PokemonInfo> pokemonInfoList = pokemonInfoService.findAllPokemonInfo();
        List<String> pokemonNameList = new ArrayList<>();

        for (PokemonInfo pokemonInfo : pokemonInfoList) {
            pokemonNameList.add(pokemonInfo.getName());
        }

        return new ResponseEntity<>(pokemonNameList, HttpStatus.OK);
    }

    @GetMapping("/pokemon/one")
    public ResponseEntity<?> getPokemonForName(@RequestParam String name){
        return new ResponseEntity<>(pokemonInfoService.findPokemonInfo(name), HttpStatus.OK);
    }

}
