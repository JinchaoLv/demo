package com.lvjc.domain;

/**
 * Created by lvjc on 2017/8/4.
 */
public class Dog {

    String name;

    public Dog(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Dog[name=" + name + "]";
    }

    @Override
    public boolean equals(Object object){
        return true;
    }
}
