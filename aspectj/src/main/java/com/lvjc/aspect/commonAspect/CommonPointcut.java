package com.lvjc.aspect.commonAspect;

import com.lvjc.annotation.NeedMonitor;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by lvjc on 2017/6/1.
 */
public class CommonPointcut {

    @Pointcut("@annotation(needMonitor)")
    protected void annotationNeedMonitor(NeedMonitor needMonitor){}
}
