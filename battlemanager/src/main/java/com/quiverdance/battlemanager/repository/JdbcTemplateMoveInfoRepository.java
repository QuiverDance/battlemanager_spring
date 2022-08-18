package com.quiverdance.battlemanager.repository;

import com.quiverdance.battlemanager.domain.MoveInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateMoveInfoRepository implements MoveInfoRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateMoveInfoRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<MoveInfo> findById(Long id) {
        List<MoveInfo> result = jdbcTemplate.query("select * from moveinfo where id = ?", moveRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public Optional<MoveInfo> findByName(String name) {
        List<MoveInfo> result = jdbcTemplate.query("select * from moveinfo where name = ?", moveRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<MoveInfo> findAll() {
        return jdbcTemplate.query("select * from moveinfo", moveRowMapper());
    }

    private RowMapper<MoveInfo> moveRowMapper(){
        return new RowMapper<MoveInfo>() {
            @Override
            public MoveInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                MoveInfo moveInfo = new MoveInfo();
                moveInfo.setId(rs.getLong("id"));
                moveInfo.setName(rs.getString("name"));
                moveInfo.setType(rs.getString("type"));
                moveInfo.setCategory(rs.getString("category"));
                moveInfo.setPower(rs.getInt("power"));
                moveInfo.setAccuracy(rs.getInt("accuracy"));
                return moveInfo;
            }
        };
    }
}
