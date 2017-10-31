package com.lvjc;

import com.lvjc.advice.introductionInterceptor.support.Controllable;
import com.lvjc.advice.throwAdvice.TransactionManager;
import com.lvjc.service.ForumService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAopApplicationTests {

    private ApplicationContext ctx;



    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void contextLoads() {
        //System.out.println(proxyFactoryBean.getClass());

    }

    @Test
    public void testSpringAOP() throws Exception {
        ForumService forumService = (ForumService) ctx.getBean("forumService");
        System.out.println(forumService.getClass());

        forumService.removeForum(2);
        forumService.updateForum();

        Controllable monitorable = (Controllable) forumService;
        monitorable.setMonitorActive(true);

        forumService.removeForum(2);
        forumService.updateForum();

    }

    @Test
    public void testMethodMonitor() throws Exception {
        ForumService forumService = (ForumService) ctx.getBean("forumService");
        forumService.removeForum(2);
        forumService.updateForum();
    }

    @Test
    public void testTransactionManager() {
        ForumService forumService = (ForumService) ctx.getBean("forumService");
        try {
            forumService.removeForum(2);
        } catch (Exception e) {
            System.out.println("未处理异常：" + e.getMessage());
        }
        try {
            forumService.updateForum();
        } catch (Exception e) {
            System.out.println("未处理异常：" + e.getMessage());
        }

        System.out.println("----------开启异常处理----------");
        TransactionManager transactionManager = (TransactionManager) ctx.getBean("transactionManager");
        transactionManager.setStatus(true);

        try {
            forumService.removeForum(2);
        } catch (Exception e) {
            System.out.println("未处理异常：" + e.getMessage());
        }
        try {
            forumService.updateForum();
        } catch (Exception e) {
            System.out.println("未处理异常：" + e.getMessage());
        }


    }




}
