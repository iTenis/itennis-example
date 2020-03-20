package com.itennishy.test.service;

import sun.awt.Mutex;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class AQSTest {
//    private static ReentrantLock mutex = new ReentrantLock();

    private static Semaphore mutex = new Semaphore(3);
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    mutex.acquire(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(3000);
                    System.out.println("b");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                }
            });
            thread.start();
        }
    }
}
