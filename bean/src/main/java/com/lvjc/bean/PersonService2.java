package com.lvjc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lvjc on 2017/6/28.
 */
//@Service
public class PersonService2 {

    @Autowired
    private Person person;

    public Person getPerson(){
        return this.person;
    }
}
