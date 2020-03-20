package com.itennishy.test;

import com.itennishy.spring.aspect.MainConfigOfAspect;
import com.itennishy.spring.aspect.divTest;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAspect.class);
        divTest divTest = (com.itennishy.spring.aspect.divTest) applicationContext.getBean("divTest");

        divTest.div(1,1);
    }
}
