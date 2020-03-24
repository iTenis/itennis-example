package com.itennishy.example.算法.动态规划算法;

import java.text.SimpleDateFormat;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-24 14:23
 */
public class 走楼梯问题 {
    public static int recursion1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return recursion1(n - 2) + recursion1(n - 3) + recursion1(n - 5);
    }

    public static int recursion2(int n) {

        int[] record = new int[n + 1];

        record[0] = 1;
        record[1] = 1;

        for (int i = 2; i < record.length; i++) {

            int n2 = i - 2 >= 0 ? record[i - 2] : 0;
            int n3 = i - 3 >= 0 ? record[i - 3] : 0;
            int n5 = i - 5 >= 0 ? record[i - 5] : 0;

            record[i] = n2 + n3 + n5;
        }

        return record[n];

    }

    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
        System.out.println(recursion1(9));
        System.out.println(recursion2(100));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
    }
}
