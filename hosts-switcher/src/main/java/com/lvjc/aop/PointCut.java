package com.lvjc.aop;

import com.lvjc.annotation.EnableLogger;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by lvjc on 2017/11/3.
 */
public class PointCut {

    @Pointcut("@target(enableLogger)")
    public void servicePointcut(EnableLogger enableLogger){}
}
