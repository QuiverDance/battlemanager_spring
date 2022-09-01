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

    public Optional<ItemInfo> findItemInfo(Long id) {
        return itemRepository.findById(id);
    }

    public Optional<ItemInfo> findItemInfo(String name) {
        return itemRepository.findByName(name);
    }

    public List<ItemInfo> findAllItemInfo() {
        return itemRepository.findAll();
    }
}
