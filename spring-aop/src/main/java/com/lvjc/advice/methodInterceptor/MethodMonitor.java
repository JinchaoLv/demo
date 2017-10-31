package com.lvjc.advice.methodInterceptor;

import com.lvjc.advice.introductionInterceptor.support.Controllable;
import com.lvjc.component.PerformanceMonitor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by lvjc on 2017/5/27.
 */
public class MethodMonitor extends DelegatingIntroductionInterceptor implements Controllable{

    private ThreadLocal<Boolean> status = new ThreadLocal<>();

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object result = null;
        if (status.get() != null && status.get()) {
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            result = super.invoke(mi);
            PerformanceMonitor.end();
        } else {
            result = super.invoke(mi);
        }
        return result;
    }

    @Override
    public void setMonitorActive(boolean active) {
        status.set(active);
    }
}
