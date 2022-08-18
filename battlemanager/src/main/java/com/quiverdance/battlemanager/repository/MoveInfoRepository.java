package com.quiverdance.battlemanager.repository;

import com.quiverdance.battlemanager.domain.MoveInfo;
import com.quiverdance.battlemanager.domain.PokemonInfo;

import java.util.List;
import java.util.Optional;

public interface MoveInfoRepository {
    Optional<MoveInfo> findById(Long id);

    Optional<MoveInfo> findByName(String name);

    List<MoveInfo> findAll();
}
