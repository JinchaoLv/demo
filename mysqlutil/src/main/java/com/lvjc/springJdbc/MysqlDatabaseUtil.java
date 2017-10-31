package com.lvjc.springJdbc;

import jdk.nashorn.internal.scripts.JD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by lvjc on 2017/6/7.
 */
public class MysqlDatabaseUtil {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createDatabase(String databaseName) {
        String sql = "create database " + databaseName;
        jdbcTemplate.execute(sql);
    }
}
