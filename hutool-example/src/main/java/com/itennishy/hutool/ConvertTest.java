package com.itennishy.hutool;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.util.Date;

public class ConvertTest {

    @Test
    public void test(){
        String dateStr = "12:00:10";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);
    }
}
