package com.lvjc;

import com.lvjc.bean.AgeGenerator;
import com.lvjc.bean.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

public class BeanApplicationTests {

	private ApplicationContext ctx;

	private final String bean_id_Person = "person";
	private final String bean_id_AgeGenerator = "ageGenerator";

	@Before
	public void setUp() {
		this.ctx = new ClassPathXmlApplicationContext("beans.xml");
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMethodReferenceAtBeansXml(){
		Person person = (Person) ctx.getBean(this.bean_id_Person);
		AgeGenerator ageGenerator = (AgeGenerator) ctx.getBean(this.bean_id_AgeGenerator);
		System.out.println(person.getAge());
	}

}
