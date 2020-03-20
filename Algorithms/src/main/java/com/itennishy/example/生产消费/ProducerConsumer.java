package com.itennishy.example.生产消费;

import java.util.LinkedList;
import java.util.PrimitiveIterator;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiehuishegn@hotmail.com
 * @version 1.0
 * @date 2020-03-20 18:08
 */
public class ProducerConsumer {

    public static void main(String[] args) {
//        PrimitiveIterator.OfLong longs = new Random().longs(10, 200).iterator();
//        PrimitiveIterator.OfInt ints = new Random().ints(1,10).iterator();
//        for (int i = 0; i <10 ; i++) {
//            System.out.println(ints.nextInt());
//        }


        MyConsumerProducer consumer = new MyConsumerProducer();
        new Thread(() -> {
            while (true) {
                System.out.println(String.format("B(mod 3) consume : %d", consumer.b_pull()));
            }
        }).start();
        new Thread(() -> {
            while (true) {
                System.out.println(String.format("C(mod 5) consume : %d", consumer.c_pull()));
            }
        }).start();
        new Thread(() -> {
            while (true) {
                System.out.println(String.format("D(other) consume : %d", consumer.d_pull()));
            }
        }).start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.start();
    }

    static class MyConsumerProducer{
        Queue<Integer> queue = new LinkedList();
        PrimitiveIterator.OfLong longs = new Random().longs(10,200).iterator();
        Lock lock = new ReentrantLock();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();
        Condition d = lock.newCondition();

        public int b_pull(){
            lock.lock();
            try{
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return queue.remove();
        }
        public int c_pull(){
            lock.lock();
            try{
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return queue.remove();
        }
        public int d_pull(){
            lock.lock();
            try{
                d.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return queue.remove();
        }
        public void start(){
            new Thread(()->{
                for (int i = 1; i <= 100; i++) {
                    queue.add(i);
                    lock.lock();
                    try{
                        if(i%3 == 0){
                            b.signal();
                        } else if(i%5 ==0 ){
                            c.signal();
                        }else{
                            d.signal();
                        }
                    }finally {
                        lock.unlock();
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(longs.nextLong());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


    }
}
