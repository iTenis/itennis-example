package com.itennishy.test.service;

import java.util.ArrayList;
import java.util.List;

public class TwoThreadCounter {

    public static volatile int nums = 0;

    public static synchronized void work(){
        nums++;
    }
    public static void main(String[] args) {
        List<Thread>  list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(new Thread(() ->{
                for(int j=0;j<1000;j++){
                        work();
                }
            }));
        }
        for (Thread thread : list) {
            thread.start();
        }

        try {
            for (Thread thread : list) {
                thread.join();
            }
            System.out.println(nums);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
