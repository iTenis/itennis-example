package com.itennishy.test.service;

import java.util.concurrent.*;

public class TestAllQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue queueLink = new LinkedBlockingQueue();
        ArrayBlockingQueue queueArray = new ArrayBlockingQueue(10);
        PriorityBlockingQueue<Work> queuepriority = new PriorityBlockingQueue<>(3);
        DelayQueue delayQueue = new DelayQueue();


        queuepriority.add(new Work(1, "name1"));
        queuepriority.add(new Work(3, "name3"));
        queuepriority.add(new Work(2, "name2"));
        queuepriority.add(new Work(4, "name4"));
        queuepriority.add(new Work(6, "name6"));
        queuepriority.add(new Work(5, "name5"));

        while (!queuepriority.isEmpty()) {
            Work take = queuepriority.take();
            System.out.println(take.getName());
        }
    }
}

class Work implements Comparable<Work> {
    private int pid;
    private String name;

    public Work(int pid, String name) {
        this.pid = pid;
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public Work() {

    }

    @Override
    public int compareTo(Work o) {
        return this.pid > o.getPid() ? 1 : (this.pid < o.getPid() ? -1 : 0);
    }
}

class Work2 implements Delayed {

    private long time;
    String name;

    public Work2(String name, long time, TimeUnit unit) {
        this.name = name;
        this.time = System.currentTimeMillis() + (time > 0 ? unit.toMillis(time) : 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return time - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}