package com.itennishy.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void add(){
        userDao.add();
        System.out.println("插入完成");
    }
}
