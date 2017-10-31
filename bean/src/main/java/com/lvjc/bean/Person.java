package com.lvjc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by lvjc on 2017/5/31.
 */
//@Component("person")
//@Scope("prototype")
public class Person {

    private int age;

    @Autowired
    @Qualifier("ageGenerator")
    private AgeGenerator ageGenerator;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = ageGenerator.getGeneratedAge();
    }
}
