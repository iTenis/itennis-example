package com.itennishy.example;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-22 15:57
 */
public class BankAccountImpl implements BankAccount {
    String name = "";
    double count = 0;

    public BankAccountImpl() {
    }

    public BankAccountImpl(String name) {
        this.name = name;
    }

    @Override
    public double queryCount() {
        return count;
    }

    @Override
    public void updateCount(double i) {
        System.out.println("账户更新：" + i);
        count = count + i;
    }
}
