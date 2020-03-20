package com.itennishy.test.service;

import com.google.common.util.concurrent.RateLimiter;

public class testRateLimiter {

    public void testAcquire() {
        RateLimiter limiter = RateLimiter.create(1);

        for(int i = 1; i < 10; i = i + 1 ) {
            double waitTime = limiter.acquire(i);
            System.out.println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
        }

    }

    public static void main(String[] args) {
        new testRateLimiter().testAcquire();
    }


}
