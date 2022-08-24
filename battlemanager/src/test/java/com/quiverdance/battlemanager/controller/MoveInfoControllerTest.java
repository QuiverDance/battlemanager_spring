package com.quiverdance.battlemanager.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MoveInfoControllerTest {
    @Autowired MoveInfoController moveInfoController;

    @Test
    void getAllMoves(){
        ResponseEntity<?> response = moveInfoController.getMoveList();
        System.out.println(response.toString());
    }

    @Test
    void getMoveByName(){
        ResponseEntity<?> response = moveInfoController.getMoveForName("화염방사");
        System.out.println(response.toString());
    }
}