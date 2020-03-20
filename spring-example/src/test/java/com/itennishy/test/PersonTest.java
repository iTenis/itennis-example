package com.itennishy.test;

import com.itennishy.spring.bean.Mainconfig;
import com.itennishy.spring.bean.Mainconfig2;
import com.itennishy.spring.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class PersonTest {

    @Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Mainconfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test02(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Mainconfig2.class);
        Person person1 = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");
        System.out.println(person1 == person2);
    }

    @Test
    public void test03(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Mainconfig2.class);
        Environment environment = applicationContext.getEnvironment();
        System.out.println(environment.getProperty("os.name"));
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        persons.forEach((s, person) -> System.out.println(s));

    }
}
