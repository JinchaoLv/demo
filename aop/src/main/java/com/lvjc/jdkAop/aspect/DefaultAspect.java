package com.lvjc.jdkAop.aspect;

/**
 * Created by lvjc on 2017/5/26.
 */
public class DefaultAspect {

    public void begin() {
        System.out.println("------method begin------");
    }

    public void end() {
        System.out.println("------method end------");
    }
}
