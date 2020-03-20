package com.itennishy.test;

import com.itennishy.spring.tx.UserService;
import com.itennishy.spring.tx.txConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {

    @Test
    public void test(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(txConfig.class);
        UserService userService = (UserService) applicationContext.getBean(UserService.class);

        userService.add();
        System.out.println("完成");
    }
}
