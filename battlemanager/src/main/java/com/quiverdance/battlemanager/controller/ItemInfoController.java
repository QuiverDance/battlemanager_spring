package com.quiverdance.battlemanager.controller;

import com.quiverdance.battlemanager.service.ItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemInfoController {
    private final ItemInfoService itemInfoService;

    @Autowired
    public ItemInfoController(ItemInfoService itemInfoService) {
        this.itemInfoService = itemInfoService;
    }

    @GetMapping("/move/all")
    public ResponseEntity<?> getItemList() {
        return new ResponseEntity<>(itemInfoService.findAllMoveInfo(), HttpStatus.OK);
    }

    @GetMapping("/move/one")
    public ResponseEntity<?> getItemForName(@RequestParam String name) {
        return new ResponseEntity<>(itemInfoService.findMoveInfo(name), HttpStatus.OK);
    }

}
