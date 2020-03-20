package com.itennishy.test.service;

import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InterruptTest6 {


//    public static void main(String[] args) throws InterruptedException {
//        ConcurrentLinkedDeque queue = new ConcurrentLinkedDeque();
//        for (int i = 0; i < 100; i++) {
//            queue.offer(i);
//        }
//        System.out.println(queue.size());
//        for (int i = 0; i < 10; i++) {
//
//            new Thread(() -> {
//                while (!queue.isEmpty())
//                    System.out.println(queue.poll() + Thread.currentThread().getName());
//            }).start();
//        }

//        TreeMap map = new TreeMap();
//        SortedMap<Object, Object> objectObjectSortedMap = Collections.synchronizedSortedMap(map);
//        objectObjectSortedMap.put("1","t");
//        System.out.println(objectObjectSortedMap.get("1"));
//        ThreadLocal<Integer> a = new ThreadLocal<Integer>();
//        a.set(1);
//        for (int i = 0; i < 5; i++) {
//            new Thread(()->{
//                a.set(a.get() + 1);
//                if(a.get()==10){
//                    System.out.println(a.get()+" "+Thread.currentThread().getName());
//                    return;
//                }
//            }).start();
//        }

//        CopyOnWriteArrayList cwa = new CopyOnWriteArrayList();
//        ArrayList cwa = new ArrayList();
//        for (int j = 0; j < 2; j++) {
//            new Thread(() -> {
//                for (int i = 0; i < 10; i++) {
//                    cwa.add(i, "tt" + i);
//                }
//            }).start();
//
//        }
//        new Thread(() -> {
//            for (Object o : cwa) {
//                System.out.println(o.toString());
//            }
//        }).start();


//        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
//        new ReentrantLock();
//        new Thread(()->{
//            lock.readLock().lock();
//            System.out.println(Thread.currentThread().getName() + " start3");
//            System.out.println(Thread.holdsLock(lock));
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " end");
//            lock.readLock().unlock();
//
//        }).start();
//        new Thread(()->{
//            lock.readLock().lock();
//            System.out.println(Thread.currentThread().getName() + " start4");
//            System.out.println(Thread.holdsLock(lock));
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " end");
//            lock.readLock().unlock();
//        }).start();
//
//
//        new Thread(()->{
//            lock.writeLock().lock();
//            System.out.println(Thread.currentThread().getName() + " start1");
//            System.out.println(Thread.holdsLock(lock));
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " end");
//            lock.writeLock().unlock();
//
//        }).start();
//        new Thread(()->{
//            lock.writeLock().lock();
//            System.out.println(Thread.currentThread().getName() + " start2");
//            System.out.println(Thread.holdsLock(lock));
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " end");
//            lock.writeLock().unlock();
//        }).start();
//

//    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "被唤醒");
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "被唤醒");
        });
        thread1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);
        LockSupport.unpark(thread1);
    }
}

