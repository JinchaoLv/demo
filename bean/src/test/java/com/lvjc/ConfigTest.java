package com.lvjc;

import com.lvjc.config.Config;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lvjc on 2017/6/20.
 */
public class ConfigTest {

    private ApplicationContext ctx;

    /*@Autowired
    @Lazy
    private Person person;*/

    @Before
    public void setUp() {
        this.ctx = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    public void testPerson(){
        Config personConfig = (Config) ctx.getBean("config");
        System.out.println(personConfig.person().getAge());
        System.out.println(personConfig.person().getAge());
        System.out.println(personConfig.person().getAge());
    }
}
