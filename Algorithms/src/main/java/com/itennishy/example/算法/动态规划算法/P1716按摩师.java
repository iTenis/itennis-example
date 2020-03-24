package com.itennishy.example.算法.动态规划算法;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-24 11:58
 */
public class P1716按摩师 {

    public static int massage(int[] nums) {
        int a = 0;
        int b = 0;
        for(int i=0;i<nums.length;i++){
            int c = Math.max(b,a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(massage(new int[]{3,1,1,3}));
    }
}
