package com.lvjc.jdkAop.invocationHandler;

import com.lvjc.jdkAop.aspect.DefaultAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lvjc on 2017/5/26.
 */
public class DefaultInvocationHandler implements InvocationHandler{

    private Object target;
    private DefaultAspect defaultAspect;

    public DefaultInvocationHandler(Object target) {
        this.target = target;
        this.defaultAspect = new DefaultAspect();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        defaultAspect.begin();
        Object obj = method.invoke(target, args);
        defaultAspect.end();
        return obj;
    }
}
