package com.lvjc.jdkAop.proxy;

import com.lvjc.jdkAop.invocationHandler.DefaultInvocationHandler;
import com.lvjc.service.ForumService;

import java.lang.reflect.Proxy;

/**
 * Created by lvjc on 2017/5/26.
 */
public class ForumServiceProxy implements ForumService {

    private ForumService proxy;

    public ForumServiceProxy(Object target) {
        DefaultInvocationHandler defaultInvocationHandler = new DefaultInvocationHandler(target);
        this.proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), defaultInvocationHandler);
    }

    @Override
    public void removeTopic(int topicId) {
        proxy.removeTopic(topicId);
    }

    @Override
    public void removeForum(int forumId) {
        proxy.removeForum(forumId);
    }

    @Override
    public void internalInvokeRemoveTopic(int topicId){
        proxy.internalInvokeRemoveTopic(topicId);
    }
}
