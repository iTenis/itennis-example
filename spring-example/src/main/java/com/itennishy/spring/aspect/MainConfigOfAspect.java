package com.itennishy.spring.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAspect {

    @Bean
    public divTest divTest(){
        return new divTest();
    }

    @Bean
    public LogAspect Log(){
        return new LogAspect();
    }
}
