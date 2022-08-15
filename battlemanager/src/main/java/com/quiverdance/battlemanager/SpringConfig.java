package com.quiverdance.battlemanager;

import com.quiverdance.battlemanager.repository.MemoryPokemonInfoRepository;
import com.quiverdance.battlemanager.repository.PokemonInfoRepository;
import com.quiverdance.battlemanager.service.PokemonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final PokemonInfoRepository pokemonInfoRepository;
    @Autowired
    public SpringConfig(PokemonInfoRepository pokemonInfoRepository) {
        this.pokemonInfoRepository = pokemonInfoRepository;
    }

    @Bean
    public PokemonInfoService pokemonInfoService(){
        return new PokemonInfoService(pokemonInfoRepository);
    }

    @Bean
    public PokemonInfoRepository pokemonInfoRepository(){
        return new MemoryPokemonInfoRepository();
    }
}
