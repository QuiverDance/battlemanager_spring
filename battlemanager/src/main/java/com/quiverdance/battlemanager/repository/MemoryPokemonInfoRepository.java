package com.quiverdance.battlemanager.repository;

import com.quiverdance.battlemanager.domain.PokemonInfo;

import java.util.*;

public class MemoryPokemonInfoRepository implements PokemonInfoRepository {

    private Map<Long, PokemonInfo> store = new HashMap<>();
    private long sequence = 0L;

    @Override
    public PokemonInfo save(PokemonInfo pokemonInfo) {
        pokemonInfo.setId(++sequence);
        store.put(pokemonInfo.getId(), pokemonInfo);
        return pokemonInfo;
    }

    @Override
    public Optional<PokemonInfo> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<PokemonInfo> findByName(String name) {
        return store.values().stream()
                .filter(pokemonInfo -> pokemonInfo.getName().equals(name))
                .findAny();
    }

    @Override
    public List<PokemonInfo> findAll() {
        return new ArrayList<>(store.values());
    }
}
