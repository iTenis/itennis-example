package com.itennishy.spring.bean;

import com.itennishy.spring.bean.condition.LinuxCond;
import com.itennishy.spring.bean.condition.windowsCond;
import com.itennishy.spring.filter.MyFilter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;


@Configuration
public class Mainconfig2 {

    @Bean("person")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Person person() {
        System.out.println("初始化");
        return new Person("lisi2", 30);
    }


    @Conditional(value = {windowsCond.class})
    @Bean("Mac")
    public Person person01(){
        return new Person("windows",64);
    }

    @Conditional(value = {LinuxCond.class})
    @Bean("linux")
    public Person person02(){
        return new Person("linux",48);
    }
}
