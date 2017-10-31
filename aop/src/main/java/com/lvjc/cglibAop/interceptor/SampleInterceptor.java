package com.lvjc.cglibAop.interceptor;

import com.lvjc.cglibAop.aspect.DefaultAspect;
import com.lvjc.cglibAop.introduce.ProxySwitch;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lvjc on 2017/5/26.
 */
public class SampleInterceptor implements MethodInterceptor, ProxySwitch {

    private boolean isProxyActive;

    private DefaultAspect defaultAspect;

    public SampleInterceptor() {
        this.defaultAspect = new DefaultAspect();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (isProxyActive) defaultAspect.begin();
        Object obj = methodProxy.invokeSuper(o, objects);
        if (isProxyActive) defaultAspect.end();
        return obj;
    }

    @Override
    public void setProxyStatus(boolean status) {
        this.isProxyActive = status;
    }
}
