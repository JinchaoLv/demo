package com.lvjc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lvjc on 2017/9/12.
 */
@Repository
public class TestDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> queryForList(String tableName){
        String sql = "select * from " + tableName;
        return jdbcTemplate.queryForList(sql);
    }
}
