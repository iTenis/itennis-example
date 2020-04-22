package com.itennishy.hutool;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-31 15:13
 */
public class TestEveryThing {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
    public static void main(String[] args) throws ParseException {

        Collections.synchronizedList(new ArrayList<>());
        long betweenDay = DateUtil.between(DateUtil.parse("2020-04-17 18:00:20"), DateUtil.parse("2020-04-17 17:00:10"), DateUnit.MINUTE);
        System.out.println(betweenDay);


        HashSet<Object> objects = new HashSet<>();
        objects.add("123");
        objects.add("456");
        System.out.println(objects);
        objects.clear();
        objects.add("567");
        System.out.println(objects);

        ConcurrentLinkedQueue<String> all = new ConcurrentLinkedQueue<>();
        all.add("1");
        all.add("2");
        System.out.println(all);
        all = new ConcurrentLinkedQueue<>();
        all.add("345");
        System.out.println(all);

    }
}

