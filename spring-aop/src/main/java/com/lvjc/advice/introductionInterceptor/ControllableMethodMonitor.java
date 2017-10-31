package com.lvjc.advice.introductionInterceptor;

import com.lvjc.advice.introductionInterceptor.support.Controllable;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;


/**
 * Created by lvjc on 2017/5/27.
 */
public class ControllableMethodMonitor extends DelegatingIntroductionInterceptor implements Controllable {
    @Override
    public void setMonitorActive(boolean active) {

    }
}
