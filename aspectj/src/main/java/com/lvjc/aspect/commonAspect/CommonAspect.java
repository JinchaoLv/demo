package com.lvjc.aspect.commonAspect;

import com.lvjc.annotation.NeedMonitor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by lvjc on 2017/6/1.
 */
@Aspect
@Component
public class CommonAspect {

    @Around("CommonPointcut.annotationNeedMonitor(needMonitor)")
    public void monitorMethod(ProceedingJoinPoint pjp, NeedMonitor needMonitor) throws Throwable {
        String value = needMonitor.value();
        String ch = needMonitor.character();
        int length = needMonitor.length();
        if(value.equals(""))
            value = this.getCompleteMethodName(pjp);
        String string = this.constructString(ch, length);
        System.out.println(string + value + ":begin" + string);
        pjp.proceed();
        System.out.println(string + value + ":end" + string);
        System.out.println();
    }

    private String getCompleteMethodName(ProceedingJoinPoint pjp) {
        StringBuffer name = new StringBuffer();
        name.append(pjp.getTarget().getClass());
        int offset = 6;
        name.delete(0, offset);
        name.append("#");
        name.append(pjp.getSignature().getName());
        return name.toString();
    }

    private String constructString(String ch, int length){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < length; ++i){
            stringBuffer.append(ch);
        }
        return stringBuffer.toString();
    }
}
