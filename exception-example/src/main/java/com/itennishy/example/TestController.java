package com.itennishy.example;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认控制器
 *
 * @author: wujian
 * @time: 2019/11/9
 */
@RestController
public class TestController {

    @RequestMapping("hello")
    public Result index() {
        return ResultUtil.getSuccess("hello world!");
    }

    @RequestMapping("login")
    public Result login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new ExceptionUtil(ResultEnum.ERROR);
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("username", username);
            map.put("password", password);
            return ResultUtil.getSuccess(map);
        }
    }
}
