package com.itennishy.spring.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class runMain {
    public static void main(String[] args) {
        SpringApplication.run(runMain.class,args);
    }
}
