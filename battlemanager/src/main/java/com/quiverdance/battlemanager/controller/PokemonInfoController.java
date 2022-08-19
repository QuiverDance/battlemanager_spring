package com.quiverdance.battlemanager.controller;

import com.quiverdance.battlemanager.domain.PokemonInfo;
import com.quiverdance.battlemanager.service.PokemonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PokemonInfoController {
    private final PokemonInfoService pokemonInfoService;

    @Autowired
    public PokemonInfoController(PokemonInfoService pokemonInfoService) {
        this.pokemonInfoService = pokemonInfoService;
    }

    @GetMapping("/pokemon/all")
    public List<PokemonInfo> getPokemonList(){
        return pokemonInfoService.findAllPokemonInfo();
    }

    @GetMapping("/pokemon/all/name")
    public List<String> getPokemonNameList(){
        List<PokemonInfo> pokemonInfoList = pokemonInfoService.findAllPokemonInfo();
        List<String> pokemonNameList = List.of();
        int size = pokemonInfoList.size();
        
        for(int i = 0; i < size; i++){
            pokemonNameList.add(pokemonInfoList.get(i).getDexId() + ". " + pokemonInfoList.get(i).getName());
        }

        return pokemonNameList;
    }

    @GetMapping("/pokemon/one")
    public Optional<PokemonInfo> getPokemonForName(@RequestParam String name){
        return pokemonInfoService.findPokemonInfo(name);
    }

}
