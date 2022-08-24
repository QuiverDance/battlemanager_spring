package com.quiverdance.battlemanager.controller;

import com.quiverdance.battlemanager.domain.MoveInfo;
import com.quiverdance.battlemanager.domain.MoveInfo;
import com.quiverdance.battlemanager.service.MoveInfoService;
import com.quiverdance.battlemanager.service.MoveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MoveInfoController {
    private final MoveInfoService moveInfoService;

    @Autowired
    public MoveInfoController(MoveInfoService moveInfoService) {
        this.moveInfoService = moveInfoService;
    }

    @GetMapping("/move/all")
    public ResponseEntity<?> getMoveList() {
        return new ResponseEntity<>(moveInfoService.findAllMoveInfo(), HttpStatus.OK);
    }

    @GetMapping("/move/all/name")
    public  ResponseEntity<?> getMoveNameList() {
        List<MoveInfo> MoveInfoList = moveInfoService.findAllMoveInfo();
        List<String> moveNameList = new ArrayList<>();

        for (MoveInfo moveInfo : MoveInfoList) {
            moveNameList.add(moveInfo.getName());
        }

        return new ResponseEntity<>(moveNameList, HttpStatus.OK);
    }

    @GetMapping("/move/one")
    public ResponseEntity<?> getMoveForName(@RequestParam String name) {
        return new ResponseEntity<>(moveInfoService.findMoveInfo(name), HttpStatus.OK);
    }

}
