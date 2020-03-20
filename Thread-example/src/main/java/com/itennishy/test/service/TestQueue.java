package com.itennishy.test.service;

import java.util.concurrent.ArrayBlockingQueue;

public class TestQueue {

    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);

        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    queue.put(++i);
                    Thread.sleep(1000 * i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
