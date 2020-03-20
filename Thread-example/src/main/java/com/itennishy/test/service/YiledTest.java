package com.itennishy.test.service;

import java.util.concurrent.ConcurrentLinkedQueue;

public class YiledTest implements Runnable {

    private String name;

    public YiledTest(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name  + ":" + i);
            if ("t1".equals(name) && i == 5) {
                System.out.println(name  + ":" + i +"......yield.............");
                Thread.yield();
            }
        }
    }

    /**
     * 暂停当前正在执行的线程对象，并执行其他线程。  *  * @param args  * @throws Exception
     */
    public static void main(String[] args) throws Exception {
//        Thread t1 = new Thread(new YiledTest("t1"));
//        Thread t2 = new Thread(new YiledTest("t2"));
//        t1.start();
//        t2.start();
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        queue.offer(1);
        queue.offer(1);
    }
}
