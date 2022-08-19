package com.quiverdance.battlemanager.service;

import com.quiverdance.battlemanager.domain.MoveInfo;
import com.quiverdance.battlemanager.domain.PokemonInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
class PokemonServiceIntegrationTest {
    @Autowired
    PokemonInfoService pokemonInfoService;

    @Test
    void findPokemons() {
        List<PokemonInfo> result = pokemonInfoService.findAllPokemonInfo();
        System.out.println(result.size());
        for(int i = 0; i < 50; i++){
            System.out.println(result.get(i).toString());
        }
    }

    @Test
    void findOne() {
        PokemonInfo result = pokemonInfoService.findPokemonInfo(50L).get();
        System.out.println(result.toString());

        PokemonInfo result2 = pokemonInfoService.findPokemonInfo("불카모스").get();
        System.out.println(result2.toString());
    }
}