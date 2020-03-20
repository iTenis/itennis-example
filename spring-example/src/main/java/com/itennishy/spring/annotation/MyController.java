package com.itennishy.spring.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("test")
    @MyAnno("test")
    public String test(){
        System.out.println("controller");
        return "success";
    }

}
