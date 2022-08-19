package com.quiverdance.battlemanager.controller;

import com.quiverdance.battlemanager.domain.MoveInfo;
import com.quiverdance.battlemanager.domain.MoveInfo;
import com.quiverdance.battlemanager.service.MoveInfoService;
import com.quiverdance.battlemanager.service.MoveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public List<MoveInfo> getMoveList() {
        return moveInfoService.findAllMoveInfo();
    }

    @GetMapping("/move/all/name")
    public List<String> getMoveNameList() {
        List<MoveInfo> MoveInfoList = moveInfoService.findAllMoveInfo();
        List<String> MoveNameList = List.of();
        int size = MoveInfoList.size();

        for (MoveInfo moveInfo : MoveInfoList) {
            MoveNameList.add(moveInfo.getId() + ". " + moveInfo.getName());
        }

        return MoveNameList;
    }

    @GetMapping("/move/one")
    public Optional<MoveInfo> getMoveForName(@RequestParam String name) {
        return moveInfoService.findMoveInfo(name);
    }

}
