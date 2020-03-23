package com.itennishy.example.算法;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-23 12:36
 */
public class P970强整数 {
    public static void main(String[] args) {
        System.out.println(powerfulIntegers(2, 3, 10));
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
//        List<Integer> res = new ArrayList<>();
//        double tmp = 0;
//
//        for (double i = 0; i < Math.sqrt(bound); i++) {
//            for (int j = 0; j < Math.sqrt(bound); j++) {
//                tmp = Math.pow(x, i) + Math.pow(y, j);
//                if (tmp <= bound && !res.contains((int)tmp)) {
//                    res.add((int) tmp);
//                }
//            }
//        }
//
//        Collections.sort(res);
//        return res;

        Set<Integer> set = new HashSet<>();

        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                set.add(a + b);
                if (y == 1) break;
            }
            if (x == 1) break;
        }

        return new ArrayList<>(set);
    }
}
