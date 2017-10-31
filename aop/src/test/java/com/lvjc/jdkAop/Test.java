package com.lvjc.jdkAop;

import com.lvjc.jdkAop.invocationHandler.DefaultInvocationHandler;
import com.lvjc.jdkAop.proxy.ForumServiceProxy;
import com.lvjc.service.ForumService;
import com.lvjc.service.impl.ForumServiceImpl;

import java.lang.reflect.Proxy;

/**
 * Created by lvjc on 2017/5/26.
 */
public class Test {

    @org.junit.Test
    public void testJdkAop() {
        ForumServiceImpl target = new ForumServiceImpl();
        ForumService proxyService = new ForumServiceProxy(target);
        //proxyService.removeTopic(2);
        //proxyService.removeForum(3);
        proxyService.internalInvokeRemoveTopic(2);
    }
}
