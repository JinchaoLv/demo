package com.lvjc.aspect;

import com.lvjc.bean.NaiveWaiter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lvjc on 2017/6/9.
 */
public class AspectInternalInvokeTest {

    private ApplicationContext ctx;

    @Before
    public void setUp(){
        this.ctx = new ClassPathXmlApplicationContext("beans.xml");
    }



}
