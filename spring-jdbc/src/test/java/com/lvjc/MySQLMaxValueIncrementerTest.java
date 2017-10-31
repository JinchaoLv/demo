package com.lvjc;

import com.lvjc.dao.DemoDao;
import com.lvjc.po.Demo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lvjc on 2017/6/19.
 */
public class MySQLMaxValueIncrementerTest {

    @Test
    public void testNextIntValue(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");
        DemoDao demoDao = (DemoDao) ctx.getBean("demoDao");
        Demo demo1 = new Demo();
        demo1.setName("demo1");
        Demo demo2 = new Demo();
        demo2.setName("demo2");
        demoDao.addDemo(demo1);
        demoDao.addDemo(demo2);
    }
}
