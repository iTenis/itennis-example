package com.itennishy.test.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Porducer {

    public static void main(String[] args) {
        LinkedList data = new LinkedList();
        ExecutorService service = Executors.newFixedThreadPool(15);

        for (int i = 0; i < 5; i++) {
            service.execute(new producer(data, 8));
        }
        for (int i = 0; i < 5; i++) {
            service.execute(new consumer(data));
        }
    }

    static class consumer implements Runnable {

        private List<Integer> list;

        public consumer(LinkedList data) {
            this.list = data;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.isEmpty()) {
                        try {
                            System.out.println("我已经消费完毕：" + Thread.currentThread().getName());
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.remove(0);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我已经消费一个：" + Thread.currentThread().getName());
                    list.notifyAll();
                }
            }
        }
    }

    static class producer implements Runnable {

        private List<Integer> list;
        private Integer maxLength;

        public producer(LinkedList data, Integer maxLength) {
            this.list = data;
            this.maxLength = maxLength;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.size() == maxLength) {
                        try {
                            System.out.println("我已经生产完毕：" + Thread.currentThread().getName());
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我已经生产了一个：" + Thread.currentThread().getName());
                    list.add(new Random().nextInt(1000));
                    list.notifyAll();
                }
            }
        }
    }
}
