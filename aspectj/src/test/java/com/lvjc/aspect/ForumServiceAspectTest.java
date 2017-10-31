package com.lvjc.aspect;

import com.lvjc.bean.ForumService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lvjc on 2017/6/1.
 */
public class ForumServiceAspectTest {

    private ApplicationContext ctx;

    @Before
    public void setUp(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void testForumServiceAspect(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ltw-beans.xml");
        ForumService proxy = (ForumService) ctx.getBean("forumService");
        //proxy.removeForum(2);
        proxy.invokeRemoveForum(2);
        /*try {
            proxy.updateForum();
        } catch (Exception e) {

        }*/
    }

    @Test
    public void testAddForum(){
        //ForumService forumService = (ForumService) ctx.getBean("forumService");
        ForumService forumService = new ForumService();
        forumService.addForum(2);
    }

    @Test
    public void testInvokeRemoveForum(){
        ForumService forumService = (ForumService) ctx.getBean("forumService");
        forumService.invokeRemoveForum(2);
    }

    @Test
    public void testRemoveForum(){
        ForumService proxyForumService = (ForumService) ctx.getBean("forumService");
        Class proxyClazz = proxyForumService.getClass();

        try{
            Method proxyRemoveForumMethod = proxyClazz.getDeclaredMethod("removeForum", int.class);
            proxyRemoveForumMethod.invoke(proxyForumService,3);
        } catch (NoSuchMethodException e){
            System.out.println("捕获异常：NoSuchMethodException");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        /*Method[] methods = proxyClazz.getDeclaredMethods();
        for(Method method : methods){
            method.setAccessible(true);
            try{
                System.out.println("调用方法：" + method.getName());
                method.invoke(proxyForumService, 2);
            }catch (IllegalArgumentException e){
                System.out.println("捕获异常：IllegalArgumentException");
            }catch (InvocationTargetException e){
                System.out.println("捕获异常：InvocationTargetException");
            } catch (IllegalAccessException e) {
                System.out.println("捕获异常：IllegalAccessException");
            }
        }*/
    }

    @Test
    public void testRemoveForum12(){

    }
}
