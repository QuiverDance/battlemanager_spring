package com.quiverdance.battlemanager.service;

import com.quiverdance.battlemanager.domain.PokemonInfo;
import com.quiverdance.battlemanager.repository.PokemonInfoRepository;

import java.util.List;
import java.util.Optional;

public class PokemonInfoService {
    private final PokemonInfoRepository pokemonInfoRepository;

    public PokemonInfoService(PokemonInfoRepository pokemonInfoRepository) {
        this.pokemonInfoRepository = pokemonInfoRepository;
    }

    public Long addPokemon(PokemonInfo pokemonInfo){
        validationDuplicatePokemon(pokemonInfo);
        pokemonInfoRepository.save(pokemonInfo);
        return pokemonInfo.getId();
    }

    private void validationDuplicatePokemon(PokemonInfo pokemonInfo){
        pokemonInfoRepository.findByName(pokemonInfo.getName())
                .ifPresent(p -> {
                    throw new IllegalStateException("이미 추가된 포켓몬 입니다.");
                });
    }

    public Optional<PokemonInfo> findPokemonInfo(Long id){
        return pokemonInfoRepository.findById(id);
    }

    public List<PokemonInfo> findAllPokemonInfo(){
        return pokemonInfoRepository.findAll();
    }
}
