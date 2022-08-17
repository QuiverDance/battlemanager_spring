package com.quiverdance.battlemanager.service;

import com.quiverdance.battlemanager.domain.PokemonInfo;
import com.quiverdance.battlemanager.repository.MemoryPokemonInfoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokemonInfoServiceTest {
    PokemonInfoService pokemonInfoService;
    MemoryPokemonInfoRepository memoryPokemonInfoRepository;

    @BeforeEach
    public void beforeEach(){
        memoryPokemonInfoRepository = new MemoryPokemonInfoRepository();
        pokemonInfoService = new PokemonInfoService(memoryPokemonInfoRepository);
    }

    @Test
    void addPokemon() {
    }

    @Test
    void findPokemonInfo() {
        PokemonInfo pokemon1 = new PokemonInfo();
        pokemon1.setName("이상해씨");
        pokemonInfoService.addPokemon(pokemon1);

        PokemonInfo pokemon2 = new PokemonInfo();
        pokemon2.setName("파이리");
        pokemonInfoService.addPokemon(pokemon2);

        PokemonInfo result = pokemonInfoService.findPokemonInfo(pokemon1.getId()).get();
        Assertions.assertThat(result.getName()).isEqualTo(pokemon1.getName());
    }

    @Test
    void findAllPokemonInfo() {
        PokemonInfo pokemon1 = new PokemonInfo();
        pokemon1.setName("이상해씨");
        pokemonInfoService.addPokemon(pokemon1);

        PokemonInfo pokemon2 = new PokemonInfo();
        pokemon2.setName("파이리");
        pokemonInfoService.addPokemon(pokemon2);

        PokemonInfo pokemon3 = new PokemonInfo();
        pokemon3.setName("꼬부기");
        pokemonInfoService.addPokemon(pokemon3);

        List<PokemonInfo> result = pokemonInfoService.findAllPokemonInfo();
        Assertions.assertThat(result.size()).isEqualTo(3);
    }
}