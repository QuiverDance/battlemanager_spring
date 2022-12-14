package com.quiverdance.battlemanager;

import com.quiverdance.battlemanager.repository.*;
import com.quiverdance.battlemanager.service.ItemInfoService;
import com.quiverdance.battlemanager.service.MoveInfoService;
import com.quiverdance.battlemanager.service.PokemonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public PokemonInfoService pokemonInfoService(){
        return new PokemonInfoService(pokemonInfoRepository());
    }
    @Bean
    public PokemonInfoRepository pokemonInfoRepository(){
        return new JdbcTemplatePokemonInfoRepository(dataSource);
    }

    @Bean
    public MoveInfoService moveInfoService(){
        return new MoveInfoService(moveInfoRepository());
    }
    @Bean
    public MoveInfoRepository moveInfoRepository(){
        return new JdbcTemplateMoveInfoRepository(dataSource);
    }

    @Bean
    public ItemInfoService itemInfoService() { return new ItemInfoService(itemInfoRepository()); }
    @Bean
    public ItemRepository itemInfoRepository() { return new JdbcTemplateItemInfoRepository(dataSource); }
}
