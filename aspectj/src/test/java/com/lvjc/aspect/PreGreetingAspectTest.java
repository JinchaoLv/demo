package com.lvjc.aspect;

import com.lvjc.aspect.waiterAspect.PreGreetingAspect;
import com.lvjc.bean.NaiveWaiter;
import com.lvjc.pojo.Waiter;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lvjc on 2017/5/31.
 */
public class PreGreetingAspectTest {

    @Test
    public void testPreGreetingAspect(){
        Waiter waiter = new NaiveWaiter();
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
        aspectJProxyFactory.setTarget(waiter);
        aspectJProxyFactory.addAspect(PreGreetingAspect.class);
        Waiter proxy = aspectJProxyFactory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("John");
    }

    @Test
    public void testPreGreetingAspect2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Waiter proxy = (Waiter) ctx.getBean("waiter");
        proxy.greetTo("John");
        proxy.serveTo("John");

    }
}
