package com.quiverdance.battlemanager.repository;

import com.quiverdance.battlemanager.domain.PokemonInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryPokemonInfoRepositoryTest {

    PokemonInfoRepository repository = new MemoryPokemonInfoRepository();

    @Test
    void save() {
        PokemonInfo pokemon = new PokemonInfo();
        pokemon.setName("이상해씨");

        repository.save(pokemon);

        PokemonInfo result = repository.findById(pokemon.getId()).get();
        Assertions.assertThat(pokemon.getName()).isEqualTo(result.getName());
    }

    @Test
    void findById() {
        PokemonInfo pokemon1 = new PokemonInfo();
        pokemon1.setName("파이리");
        repository.save(pokemon1);

        PokemonInfo pokemon2 = new PokemonInfo();
        pokemon2.setName("꼬부기");
        repository.save(pokemon2);

        PokemonInfo result = repository.findById(pokemon2.getId()).get();
        Assertions.assertThat(pokemon2.getName()).isEqualTo(result.getName());
    }

    @Test
    void findAll() {
        PokemonInfo pokemon1 = new PokemonInfo();
        pokemon1.setName("이상해씨");
        repository.save(pokemon1);

        PokemonInfo pokemon2 = new PokemonInfo();
        pokemon2.setName("파이리");
        repository.save(pokemon2);

        PokemonInfo pokemon3 = new PokemonInfo();
        pokemon3.setName("꼬부기");
        repository.save(pokemon3);
        
        List<PokemonInfo> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(3);
    }
}