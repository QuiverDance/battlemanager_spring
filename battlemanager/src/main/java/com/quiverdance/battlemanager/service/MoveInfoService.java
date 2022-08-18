package com.quiverdance.battlemanager.service;

import com.quiverdance.battlemanager.domain.MoveInfo;
import com.quiverdance.battlemanager.domain.PokemonInfo;
import com.quiverdance.battlemanager.repository.MoveInfoRepository;
import com.quiverdance.battlemanager.repository.PokemonInfoRepository;

import java.util.List;
import java.util.Optional;

public class MoveInfoService {
    private final MoveInfoRepository moveInfoRepository;

    public MoveInfoService(MoveInfoRepository moveInfoRepository) {
        this.moveInfoRepository = moveInfoRepository;
    }

    public Optional<MoveInfo> findMoveInfo(Long id) {
        return moveInfoRepository.findById(id);
    }

    public List<MoveInfo> findAllMoveInfo() {
        return moveInfoRepository.findAll();
    }
}
