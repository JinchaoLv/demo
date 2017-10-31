package com.lvjc.aspect.waiterAspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by lvjc on 2017/5/31.
 */
@Aspect
public class PreGreetingAspect {

    @Before("execution(* serveTo(..))")
    public void beforeGreeting(){
        System.out.println("How are you");
    }
}
