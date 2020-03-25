package com.itennishy.example.生产消费;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-03-25 09:50
 */
public class 多线程消费 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue(10);
        MyProducer producer = new MyProducer(queue);
        producer.start();
        List<Future> task = new ArrayList<>();
        ExecutorService pool = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS, new ArrayBlockingQueue(100));

        for (int i = 0; i < 5; i++) {
            Future f = pool.submit(new MyConsumer(queue));
            task.add(f);
        }
        pool.shutdown();
        for (Future f : task) {
            System.out.println(">>>" + f.get().toString());
        }
    }


}

class MyProducer {
    private BlockingQueue<Integer> queue;

    public MyProducer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void start() {
        System.out.println("查询数据库，写入队列");
        new Thread(() -> {
            for (int i = 0; ; i++) {
                System.out.println("添加到队列:" + i);
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class MyConsumer implements Callable {
    private BlockingQueue<Integer> queue;

    public MyConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public Object call() throws Exception {
        while (true) {
            System.out.println("消费者" + Thread.currentThread().getName() + "消费:" + queue.take());
        }
    }
}
