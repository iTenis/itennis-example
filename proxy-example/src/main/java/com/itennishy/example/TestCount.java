package com.itennishy.example;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-22 16:20
 */
public class TestCount {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccountImpl("张三");
        bankAccount.updateCount(10);
        bankAccount.queryCount();

        BankAccount bankAccount1 = new BankAccountStaticProxy(bankAccount);
        bankAccount1.updateCount(100);
        bankAccount1.queryCount();

        JDKProxyFactory jdkProxyFactory = new JDKProxyFactory();
        BankAccount bind = (BankAccount) jdkProxyFactory.bind(bankAccount);
        bind.updateCount(10);
        bind.queryCount();

        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory();
        BankAccount proxyIntance = (BankAccount) cglibProxyFactory.createProxyIntance(bankAccount);
        proxyIntance.updateCount(1);
        proxyIntance.queryCount();

        BankAccountNoImpl bankAccountNo = new BankAccountNoImpl("小明");
        CglibProxyFactory cglibProxyFactory1 = new CglibProxyFactory();
        BankAccountNoImpl proxyIntance1 = (BankAccountNoImpl) cglibProxyFactory1.createProxyIntance(bankAccountNo);
        proxyIntance1.updateCount(100);
        proxyIntance1.queryCount();

        //会报错
        JDKProxyFactory jdkProxyFactory1 = new JDKProxyFactory();
        BankAccount bind1 = (BankAccount) jdkProxyFactory1.bind(bankAccountNo);
        bind1.updateCount(10);
        bind1.queryCount();
    }
}
