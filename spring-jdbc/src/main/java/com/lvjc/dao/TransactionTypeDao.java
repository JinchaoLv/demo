package com.lvjc.dao;

import com.lvjc.po.TransactionType;
import org.springframework.stereotype.Repository;

/**
 * Created by lvjc on 2017/6/7.
 */
@Repository
public class TransactionTypeDao extends BaseDao<TransactionType> {


    @Override
    protected String getTableName(TransactionType entity) {
        return null;
    }

    @Override
    protected String getTableName(String id) {
        return null;
    }
}
