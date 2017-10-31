package com.lvjc.dao;

//import com.lvjc.support.id.IdGenerator;
import com.lvjc.support.incrementer.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.stereotype.Repository;


import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by lvjc on 2017/6/7.
 */
@Repository
public abstract class BaseDao<T> {

    private JdbcTemplate jdbcTemplate;

    private IdGenerator idGenerator;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setIdGenerator(IdGenerator idGenerator){
        this.idGenerator = idGenerator;
    }

    protected abstract String getTableName(T entity);

    protected abstract String getTableName(String id);

    public List<Map<String, Object>> queryForList(String tableName){
        String sql = "select * from " + tableName;
        return jdbcTemplate.queryForList(sql);
    }

    public BaseDao<T> insert(T entity) throws SQLException {
        String tableName = this.getTableName(entity);
        Object[] params = null;
        try {
            params = this.getDeclaredFieldValues(entity.getClass(), entity);
        } catch (IllegalAccessException e) {
            throw new SQLException();
        }
        StringBuilder sql = new StringBuilder("insert into " + tableName + " values(" + idGenerator.generateId(tableName));
        for (int i = 0; i < params.length; ++i){
            if(i != params.length - 1)
                sql.append(",");
            else{
                sql.append(")");
                break;
            }
            sql.append("?");
        }
        jdbcTemplate.update(sql.toString(), params);
        return this;
    }

    public BaseDao<T> update(T entity){
        return this;
    }

    private String[] getDeclaredFieldNames(Class clazz) throws ClassNotFoundException {
        Field[] fields = clazz.getDeclaredFields();
        String[] names = new String[fields.length];
        for (int i = 0; i < fields.length; ++i){
            names[i] = fields[i].getName();
        }
        return names;
    }

    private Object[] getDeclaredFieldValues(Class clazz, Object target) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        Object[] values = new Object[fields.length];
        for(int i = 0; i < fields.length; ++i){
            fields[i].setAccessible(true);
            values[i] = fields[i].get(target);
        }
        return values;
    }


}
