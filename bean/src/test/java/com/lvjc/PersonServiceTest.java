package com.lvjc;

import com.lvjc.bean.Person;
import com.lvjc.bean.PersonService1;
import com.lvjc.bean.PersonService2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lvjc on 2017/6/28.
 */
public class PersonServiceTest {

    private ApplicationContext ctx;

    @Before
    public void setUp() {
        this.ctx = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void test(){
        PersonService1 personService1 = (PersonService1) ctx.getBean("personService1");
        PersonService2 personService2 = (PersonService2) ctx.getBean("personService2");
        personService1.getPerson().setAge(20);
        System.out.println(personService1.getPerson().getAge());
        System.out.println(personService2.getPerson().getAge());
        personService2.getPerson().setAge(30);
        System.out.println(personService1.getPerson().getAge());
        System.out.println(personService2.getPerson().getAge());
    }
}
