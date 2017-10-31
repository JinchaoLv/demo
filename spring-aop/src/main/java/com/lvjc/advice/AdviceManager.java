package com.lvjc.advice;

import org.aopalliance.aop.Advice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

/**
 * Created by lvjc on 2017/5/27.
 */
public class AdviceManager {

    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");


}
