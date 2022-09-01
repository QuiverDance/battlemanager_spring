package com.quiverdance.battlemanager.service;

import com.quiverdance.battlemanager.domain.ItemInfo;
import com.quiverdance.battlemanager.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

public class ItemInfoService {
    private final ItemRepository itemRepository;

    public ItemInfoService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Optional<ItemInfo> findMoveInfo(Long id) {
        return itemRepository.findById(id);
    }

    public Optional<ItemInfo> findMoveInfo(String name) {
        return itemRepository.findByName(name);
    }

    public List<ItemInfo> findAllMoveInfo() {
        return itemRepository.findAll();
    }
}
