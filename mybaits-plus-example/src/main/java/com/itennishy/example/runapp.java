package com.itennishy.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itennishy.example.mapper")
public class runapp {
    public static void main(String[] args) {
        SpringApplication.run(runapp.class,args);
    }
}
