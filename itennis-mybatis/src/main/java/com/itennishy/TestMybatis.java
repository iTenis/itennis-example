package com.itennishy;

import com.itennishy.bean.User;
import com.itennishy.mapper.UserMapper;
import com.itennishy.sqlsession.MySqlsession;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-28 10:26
 */
public class TestMybatis {
    public static void main(String[] args) {
        MySqlsession sqlsession=new MySqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.getUserById("100");
        System.out.println(user);
    }

}
