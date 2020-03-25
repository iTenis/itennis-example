package com.itennishy.example.算法;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-25 14:36
 */

import java.math.BigDecimal;

/**
 * 题目：请编写一个红包随机算法。
 * 给定一定的金额，一定的人数，保证每个人都能随机获得一定的金额。
 * 比如100元的红包，10个人抢，每人分得一些金额。约束条件为，最佳手气金额不能超过最大金额的90%。
 *
 * 本算法每次随机金额范围[min,每次剩余平均值]
 */
public class 红包随机算法 {
    public static void main(String[] args) {
        //金额，个数，最少值
        redPacket(100, 10, 0.01);
    }

    static void redPacket(double total, int num, double min) {
        for (int i = 1; i < num; i++) {
            double safe_total = (total - (num - i) * min) / (num - i);
//            double safe_total = (total - (num - i) * min) * 0.9;
            double money = Math.random() * (safe_total - min) + min;
            BigDecimal money_bd = new BigDecimal(money);
            money = money_bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            total = total - money;
            BigDecimal total_bd = new BigDecimal(total);
            total = total_bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println("第" + i + "个红包：" + money + ",余额为:" + total + "元");
        }
        System.out.println("第" + num + "个红包：" + total + ",余额为:0元");

    }
}
