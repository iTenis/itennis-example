package com.itennishy.example.controller;

import com.itennishy.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    public String UserGURD(){
        userMapper.selectById("1");
        return "success";
    }
}
