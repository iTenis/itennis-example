package com.itennishy.hutool;


import java.util.concurrent.*;

public class TestHutool {


    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(2,4,20, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(3);
        pool2.scheduleAtFixedRate(()->{
            System.out.println("-----");
        }, 10, 20, TimeUnit.SECONDS);

    }
}
