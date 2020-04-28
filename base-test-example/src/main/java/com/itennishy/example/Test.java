package com.itennishy.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-23 10:02
 */
public class Test extends test4{


    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.getClass());
        System.out.println(test.toString());
        System.out.println(test.hashCode());
        System.out.println(test.getClass().getName());
        System.out.println(test.equals(new Test()));
        List list = new ArrayList<>();
    }

    public final void test(){
    }
}

class test4{

}
abstract class test1{

    private String t;

    public void test(){
        System.out.println("ceshi");
    }
    public abstract void test2();
}

interface test3{
    public String t = "";

    default public void test(){

    }
    public void test2();
}
