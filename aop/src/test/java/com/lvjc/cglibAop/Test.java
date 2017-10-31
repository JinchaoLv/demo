package com.lvjc.cglibAop;

import com.lvjc.cglibAop.proxy.ForumServiceProxy;
import com.lvjc.service.impl.ForumServiceImpl;

/**
 * Created by lvjc on 2017/5/26.
 */
public class Test {

    @org.junit.Test
    public void testAop() {
        ForumServiceProxy proxy = new ForumServiceProxy();
        System.out.println("------代理是否开启：" + proxy.getProxyStatus() + "------");
        proxy.removeTopic(2);
        proxy.removeForum(3);

        proxy.setProxyStatus(true);
        System.out.println("------代理是否开启：" + proxy.getProxyStatus() + "------");
        proxy.removeTopic(2);
        proxy.removeForum(3);
    }
}
