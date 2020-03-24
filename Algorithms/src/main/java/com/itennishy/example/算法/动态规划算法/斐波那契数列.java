package com.itennishy.example.算法.动态规划算法;

import java.text.SimpleDateFormat;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-24 14:03
 */
public class 斐波那契数列 {
    /**
     * 递归方式求解
     *
     * @param n
     * @return
     */
    public static int recursion1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return recursion1(n - 1) + recursion1(n - 2);
    }

    /**
     * 迭代，动态规划
     *
     * @param n
     * @return
     */
    public static int resursion2(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
        recursion1(3000);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
    }
}
