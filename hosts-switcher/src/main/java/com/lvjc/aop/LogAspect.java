package com.lvjc.aop;

import com.lvjc.annotation.EnableLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by lvjc on 2017/11/3.
 */
@Component
@Aspect
public class LogAspect {

    //@Before("PointCut.servicePointcut(enableLogger)")
    @Before("@target(com.lvjc.annotation.EnableLogger)")
    //@Before("@annotation(com.lvjc.annotation.EnableLogger)")
    public void serviceLog(JoinPoint joinPoint) throws ClassNotFoundException {
        //String className = enableLogger.value();
        String className = "";
        Logger logger = LoggerFactory.getLogger(Class.forName(className));

        Object[] args = joinPoint.getArgs();
        StringBuilder info = new StringBuilder("invoke method: " + joinPoint.getSignature().getName() + "(");
        for(Object arg : args){
            info.append(arg.getClass().getName());
            info.append(",");
        }
        info.append(")");

        logger.info(info.toString());
    }

}
