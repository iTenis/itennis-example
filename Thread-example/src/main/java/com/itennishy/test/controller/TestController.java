package com.itennishy.test.controller;

import com.google.common.util.concurrent.RateLimiter;
import com.itennishy.test.service.OrderTaskServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class TestController {
    @Autowired
    private OrderTaskServic orderTaskServic;

    RateLimiter rateLimiter = RateLimiter.create(3);

    @GetMapping("/test1")
    @ResponseBody
    public void test1() {
        if(rateLimiter.tryAcquire(1)){
            System.out.println("测试:" + new Date(System.currentTimeMillis()));
        }else {
            System.out.println("限流成功");
        }


    }

}
