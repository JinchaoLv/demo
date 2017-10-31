package com.lvjc.cglibAop.proxy;

import com.lvjc.cglibAop.interceptor.SampleInterceptor;
import com.lvjc.cglibAop.introduce.ProxySwitch;
import com.lvjc.service.impl.ForumServiceImpl;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by lvjc on 2017/5/26.
 */
public class ForumServiceProxy extends ForumServiceImpl{

    private boolean isProxyActive;

    private SampleInterceptor sampleInterceptor;

    private ForumServiceImpl proxy;

    public ForumServiceProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ForumServiceImpl.class);
        this.sampleInterceptor = new SampleInterceptor();
        enhancer.setCallback(this.sampleInterceptor);
        this.proxy = (ForumServiceImpl) enhancer.create();
    }

    @Override
    public void removeForum(int forumId) {
        proxy.removeForum(forumId);
    }

    @Override
    public void removeTopic(int topicId) {
        proxy.removeTopic(topicId);
    }

    public void setProxyStatus(boolean status) {
        this.isProxyActive = status;
        this.sampleInterceptor.setProxyStatus(status);
    }

    public boolean getProxyStatus() {
        return this.isProxyActive;
    }
}
