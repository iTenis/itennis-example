package com.itennishy.example.生产消费;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-25 10:55
 */
public class 多线程消费2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        Producer producer = new Producer(queue);
        Thread p = new Thread(producer);
        p.start();

        ExecutorService pool = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
        List<Future> tasks = new ArrayList<>();
        while (true) {
            for (int i = 0; i < 5; i++) {
                tasks.add(pool.submit(new Consumer(queue)));
            }
            for (Future task : tasks) {
                System.out.println("消费结束：" + task.get());
            }
            tasks = new ArrayList<>();
        }


    }

}


class Producer implements Runnable {
    private final BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            try {
                queue.put(i);
//                System.out.println("生成者生成:" + i);
                Thread.sleep(100);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Callable {
    private final BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("消费" + Thread.currentThread().getName() + "->>> " + queue.take());
        Thread.sleep(1000);
        return Thread.currentThread().getName() + " -> success";
    }
}
