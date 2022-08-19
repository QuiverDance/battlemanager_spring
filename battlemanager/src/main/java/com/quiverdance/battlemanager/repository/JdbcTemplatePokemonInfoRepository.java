package com.quiverdance.battlemanager.repository;

import com.quiverdance.battlemanager.domain.PokemonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JdbcTemplatePokemonInfoRepository implements PokemonInfoRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplatePokemonInfoRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public PokemonInfo save(PokemonInfo pokemonInfo) {
        return null;
    }

    @Override
    public Optional<PokemonInfo> findById(Long id) {
        List<PokemonInfo> result = jdbcTemplate.query("select * from pokemoninfo where id = ?", pokemonRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public Optional<PokemonInfo> findByName(String name) {
        List<PokemonInfo> result = jdbcTemplate.query("select * from pokemoninfo where name = ?", pokemonRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<PokemonInfo> findAll() {
        return jdbcTemplate.query("select * from PokemonInfo", pokemonRowMapper());
    }

    private RowMapper<PokemonInfo> pokemonRowMapper(){
        return new RowMapper<PokemonInfo>() {
            @Override
            public PokemonInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                PokemonInfo PokemonInfo = new PokemonInfo();
                PokemonInfo.setId(rs.getLong("id"));
                PokemonInfo.setImageUrl(rs.getString("imgurl"));
                PokemonInfo.setDexId(rs.getInt("dexid"));
                PokemonInfo.setName(rs.getString("name"));
                PokemonInfo.setType1(rs.getString("type1"));
                PokemonInfo.setType2(rs.getString("type2"));
                PokemonInfo.setAbility1(rs.getString("ability1"));
                PokemonInfo.setAbility2(rs.getString("ability2"));
                PokemonInfo.setAbility3(rs.getString("ability3"));
                PokemonInfo.setH(rs.getInt("h"));
                PokemonInfo.setA(rs.getInt("a"));
                PokemonInfo.setB(rs.getInt("b"));
                PokemonInfo.setC(rs.getInt("c"));
                PokemonInfo.setD(rs.getInt("d"));
                PokemonInfo.setS(rs.getInt("s"));
                PokemonInfo.setGenderType(rs.getInt("gendertype"));
                PokemonInfo.setWeight(rs.getFloat("weight"));
                return PokemonInfo;
            }
        };
    }
}
