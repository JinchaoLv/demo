package com.lvjc.cglibAop.aspect;

/**
 * Created by lvjc on 2017/5/26.
 */
public class DefaultAspect {

    public static void begin() {
        System.out.println("------method begin------");
    }

    public static void end() {
        System.out.println("------method end------");
    }
}
