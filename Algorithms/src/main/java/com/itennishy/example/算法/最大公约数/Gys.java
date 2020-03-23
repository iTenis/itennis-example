package com.itennishy.example.算法.最大公约数;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-21 16:46
 */
public class Gys {

    public boolean canMeasureWater(int x, int y, int z) {
        int tmp = gcd(5, 3);
        return true;
    }

    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
    public static void main(String[] args) {
        System.out.println(gcd(28,46));
    }
}
