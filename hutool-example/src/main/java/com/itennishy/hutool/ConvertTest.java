package com.itennishy.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ConvertTest {

    @Test
    public void test(){
        String dateStr = "12:00:10";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);
    }
}
