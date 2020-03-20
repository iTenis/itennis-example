package com.itennishy.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Test {
    public static void main(String[] args) {
        SpringApplication.run(Test.class,args);
    }
}
