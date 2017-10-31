package com.lvjc.bean;

import com.lvjc.annotation.NeedMonitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by lvjc on 2017/5/27.
 */
@Component
public class ForumService {

    @NeedMonitor
    public void removeForum(int forumId) {
        System.out.println("删除forum记录：" + forumId);
    }

    @NeedMonitor
    private void removeForum1(){
        System.out.println("removeForum1");
    }

    @NeedMonitor
    public void removeForum2(){
        System.out.println("removeForum2");
    }

    @NeedMonitor("kkkkkkkkkkkkkkkkkkkkkkk")
    public void addForum(int forumId){
        System.out.println("添加forum记录" + forumId);
    }

    @NeedMonitor
    public void updateForum() throws Exception{
        System.out.println("发生异常");
        throw new SQLException("数据更新异常");
    }

    public void invokeRemoveForum(int forumId){
        System.out.println("invoke remove forum...");
        removeForum(forumId);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ltw-beans.xml");
        ForumService proxy = (ForumService) ctx.getBean("forumService");
        proxy.invokeRemoveForum(2);
    }
}
