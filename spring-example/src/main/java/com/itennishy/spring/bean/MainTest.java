package com.itennishy.spring.bean;

import com.sun.xml.internal.xsom.parser.AnnotationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
//        配置方式
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person);
        System.out.println("开始1");

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Mainconfig.class);
        System.out.println("开始2");
        Person person = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");
        System.out.println("开始3");
        System.out.println(person == person2);

//        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (int i = 0; i <beanDefinitionNames.length ; i++) {
//            System.out.println(beanDefinitionNames[i]);
//        }



    }
}
