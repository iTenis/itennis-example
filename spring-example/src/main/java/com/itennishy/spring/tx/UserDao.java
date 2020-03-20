package com.itennishy.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void add() {
        String sql = "insert into user (name,age) values (?,?)";
        String name = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql, name, 12);
        int i = 10/0;
    }
}
