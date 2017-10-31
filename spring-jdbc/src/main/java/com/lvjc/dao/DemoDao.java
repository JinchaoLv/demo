package com.lvjc.dao;

import com.lvjc.po.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.stereotype.Repository;

/**
 * Created by lvjc on 2017/6/19.
 */
@Repository
public class DemoDao {

    private static final String SQL = "INSERT INTO t_demo values(?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataFieldMaxValueIncrementer incrementer;

    public void addDemo(Demo demo){
        demo.setId(incrementer.nextIntValue());
        Object[] params = new Object[]{demo.getId(), demo.getName()};
        jdbcTemplate.update(SQL, params);
    }
}
