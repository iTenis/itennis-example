package com.itennishy.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
//@Component
@Service
public class OrderTaskServic {

    @Async
    public void orderTask(int i) throws InterruptedException {
        log.info("发送短信方法---- "+i+"   执行开始");
        Thread.sleep(5000); // 模拟耗时
        log.info("发送短信方法---- "+i+"   执行结束");
    }

}