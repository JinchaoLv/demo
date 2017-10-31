package com.lvjc.dao;

import com.lvjc.po.Transaction;
import org.springframework.stereotype.Repository;

/**
 * Created by lvjc on 2017/6/7.
 */
@Repository
public class TransactionDao extends BaseDao<Transaction> {
    @Override
    protected String getTableName(Transaction entity) {
        return null;
    }

    @Override
    protected String getTableName(String id) {
        return null;
    }
}
