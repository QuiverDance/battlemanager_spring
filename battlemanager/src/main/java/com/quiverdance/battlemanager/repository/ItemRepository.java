package com.quiverdance.battlemanager.repository;

import com.quiverdance.battlemanager.domain.ItemInfo;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Optional<ItemInfo> findById(Long id);

    Optional<ItemInfo> findByName(String name);

    List<ItemInfo> findAll();
}
