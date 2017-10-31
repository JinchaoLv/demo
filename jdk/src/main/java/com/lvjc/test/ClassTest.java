package com.lvjc.test;

/**
 * Created by lvjc on 2017/7/13.
 */
public class ClassTest {

    public static Class getRuntimeClass(Object obj){
        return obj.getClass();
    }

    public static void main(String[] args) {
        DateTest date = new DateTest();
        System.out.println(ClassTest.getRuntimeClass(date));
    }
}
