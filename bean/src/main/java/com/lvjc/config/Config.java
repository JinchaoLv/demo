package com.lvjc.config;

import com.lvjc.bean.AgeGenerator;
import com.lvjc.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * Created by lvjc on 2017/6/20.
 */
@Configuration
public class Config {

    @Bean("person")
    @Scope("prototype")
    public Person person(){
        Person person = new Person();
        AgeGenerator ageGenerator = this.ageGenerator();
        person.setAge(ageGenerator.getGeneratedAge());
        return person;
    }

    @Bean
    public AgeGenerator ageGenerator(){
        return new AgeGenerator();
    }
}
