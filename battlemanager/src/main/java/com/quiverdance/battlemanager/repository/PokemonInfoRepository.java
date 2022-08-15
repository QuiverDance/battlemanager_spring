package com.quiverdance.battlemanager.repository;

import com.quiverdance.battlemanager.domain.PokemonInfo;

import java.util.List;
import java.util.Optional;

public interface PokemonInfoRepository {
    PokemonInfo save(PokemonInfo pokemonInfo);
    Optional<PokemonInfo> findById(Long id);
    Optional<PokemonInfo> findByName(String name);
    List<PokemonInfo> findAll();
}
