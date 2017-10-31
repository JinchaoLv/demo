package com.lvjc.advice.throwAdvice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by lvjc on 2017/5/27.
 */
public class TransactionManager implements ThrowsAdvice{

    private boolean status;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable{
        if (status) {
            System.out.println("method:" + method.getName());
            System.out.println("抛出异常：" + ex.getMessage());
            System.out.println("成功回滚事务。");
        } else {
            method.invoke(target, args);
        }
    }
}
