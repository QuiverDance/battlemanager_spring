package com.quiverdance.battlemanager.service;

import com.quiverdance.battlemanager.domain.MoveInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.Charset;
import java.util.List;


@SpringBootTest
@Transactional
class MoveServiceIntegrationTest {
    @Autowired
    MoveInfoService moveInfoService;

    @Test
    void findMoves() {
        List<MoveInfo> result = moveInfoService.findAllMoveInfo();
        System.out.println(result.size());
        System.out.println(result.get(0).getName());
    }

    @Test
    void findOne() {
    }
}