package com.lvjc.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by lvjc on 2017/6/21.
 */
@Component
//@Scope("prototype")
public class AnnotationBean {

    private int value;

    public AnnotationBean(){
        System.out.println("construct...");
    }

    @PostConstruct
    private void init(){
        System.out.println("post construct");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("pre destroy");
    }
}
