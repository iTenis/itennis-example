package com.itennishy.example;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-22 15:54
 */
public class BankAccountStaticProxy implements BankAccount {

    public BankAccount bankAccount;

    public BankAccountStaticProxy(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public double queryCount() {
        System.out.println("静态代理查询账户信息");
        return bankAccount.queryCount();
    }

    @Override
    public void updateCount(double i) {
        System.out.println("静态代理更新账户信息");
        bankAccount.updateCount(i);
    }
}
