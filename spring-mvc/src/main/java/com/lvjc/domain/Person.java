package com.lvjc.domain;

/**
 * Created by lvjc on 2017/8/4.
 */
public class Person {

    String name;

    public Person(String name){
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
        return "Person[name=" + name + "]";
    }

    @Override
    public boolean equals(Object object){
        return true;
    }
}
