package com.lvjc.aspect.forumServiceAspect;

import com.lvjc.annotation.NeedMonitor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

/**
 * Created by lvjc on 2017/6/1.
 */
@Aspect
public class ForumServiceAspect {

    @Pointcut("target(com.lvjc.bean.ForumService)")
    private void targetForumService(){}

    @AfterThrowing(value = "targetForumService()", throwing = "sqle")
    public void sqlExceptionProcessor(SQLException sqle) {
        System.out.println("捕获异常：" + sqle.getMessage());
        System.out.println("处理成功。");
    }

    @Before("execution(* removeForum(..)) && target(com.lvjc.bean.ForumService)")
    public void beforeInvoke(){
        System.out.println("before...");
    }

    @AfterReturning("execution(private * removeForum(..))")
    public void afterReturningInvoke(){
        System.out.println("增强私有方法");
    }

}
