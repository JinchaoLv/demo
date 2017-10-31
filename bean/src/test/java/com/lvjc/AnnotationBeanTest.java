package com.lvjc;

import com.lvjc.bean.AnnotationBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lvjc on 2017/6/21.
 */
public class AnnotationBeanTest {

    private ApplicationContext ctx;

    @Before
    public void setUp() {
        this.ctx = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void testPostConstructAndPreDestroy(){
        AnnotationBean annotationBean = (AnnotationBean) ctx.getBean("annotationBean");
        ((ClassPathXmlApplicationContext)ctx).destroy();
    }
}
