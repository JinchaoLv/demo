package com.lvjc.bean;

import java.util.Random;

/**
 * Created by lvjc on 2017/5/31.
 */
public class AgeGenerator {

    public int getGeneratedAge(){
        Random random = new Random();
        System.out.println("A random age is generated :)");
        return random.nextInt(100);
    }
}
