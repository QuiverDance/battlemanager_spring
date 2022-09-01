package com.quiverdance.battlemanager.repository;

import com.quiverdance.battlemanager.domain.ItemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateItemInfoRepository implements ItemRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateItemInfoRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<ItemInfo> findById(Long id) {
        List<ItemInfo> result = jdbcTemplate.query("select * from iteminfo where id = ?", itemRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public Optional<ItemInfo> findByName(String name) {
        List<ItemInfo> result = jdbcTemplate.query("select * from iteminfo where name = ?", itemRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<ItemInfo> findAll() {
        return jdbcTemplate.query("select * from iteminfo", itemRowMapper());
    }

    private RowMapper<ItemInfo> itemRowMapper(){
        return new RowMapper<ItemInfo>() {
            @Override
            public ItemInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                ItemInfo itemInfo = new ItemInfo();
                itemInfo.setId(rs.getLong("id"));
                itemInfo.setName(rs.getString("name"));
                itemInfo.setCategory(rs.getString("category"));
                return itemInfo;
            }
        };
    }
}
