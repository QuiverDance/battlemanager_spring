package com.quiverdance.battlemanager.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class ItemInfoControllerTest {
    @Autowired ItemInfoController itemInfoController;

    @Test
    void getItemList(){
        ResponseEntity<?> response = itemInfoController.getItemList();
        System.out.println(response.toString());
    }

    @Test
    void getItemByName(){
        ResponseEntity<?> response = itemInfoController.getItemByName("푸른하늘플레이트");
        System.out.println(response.toString());
    }
}