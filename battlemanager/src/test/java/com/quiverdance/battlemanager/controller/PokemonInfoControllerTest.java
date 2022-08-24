package com.quiverdance.battlemanager.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class PokemonInfoControllerTest {
    @Autowired
    PokemonInfoController pokemonInfoController;

    @Test
    void getAllPokemonInfo(){
        ResponseEntity<?> result = pokemonInfoController.getPokemonList();
        System.out.println(result.toString());
    }

    @Test
    void getPokemonNames(){
        ResponseEntity<?> result = pokemonInfoController.getPokemonNameList();
        System.out.println(result.toString());
    }
    
    @Test
    void getPokemonByName(){
        ResponseEntity<?> result = pokemonInfoController.getPokemonByName("불카모스");
        System.out.println(result.toString());
    }
}