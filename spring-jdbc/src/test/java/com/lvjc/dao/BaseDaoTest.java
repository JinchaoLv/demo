package com.lvjc.dao;

import com.lvjc.po.Transaction;
import com.lvjc.po.TransactionType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by lvjc on 2017/6/7.
 */
public class BaseDaoTest {

    private TestDao testDao;
    private BaseDao baseDao;
    private TransactionDao transactionDao;
    private TransactionTypeDao transactionTypeDao;

    @Before
    public void setUp(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        this.testDao = (TestDao) ctx.getBean("testDao");
        //this.baseDao = (BaseDao) ctx.getBean("baseDao");
        this.transactionDao = (TransactionDao) ctx.getBean("transactionDao");
        this.transactionTypeDao = (TransactionTypeDao) ctx.getBean("transactionTypeDao");
    }

    @Test
    public void testInsert() throws SQLException {
        TransactionType transactionType = new TransactionType();
        transactionType.setType_trans_id(2);
        transactionType.setType_trans_name("收入");
        this.transactionTypeDao.insert(transactionType);
        Transaction transaction = new Transaction();
        this.transactionDao.insert(transaction);
    }

    @Test
    public void testQueryForList(){
        System.out.println(testDao.queryForList("t_admin"));
    }
}
