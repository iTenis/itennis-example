package com.itennishy.test.service;


public class DeadLock {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            work t = new work();
            t.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    static class work extends Thread {

        @Override
        public void run() {
            synchronized (work.class) {
                for (int i = 0; i < 100000; i++) {
                    count++;
                }
            }
        }
    }
}
