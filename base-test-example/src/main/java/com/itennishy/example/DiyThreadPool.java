package com.itennishy.example;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-23 17:00
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * @author DUCHONG
 * @since 2019-09-04 9:54
 **/
public class DiyThreadPool {

    private static int maxNum=16;

    public static void main(String[] args)throws Exception {
        //被拒绝执行的任务Runnable集合
        List<Runnable> rejectTask=new ArrayList<>();
        //设置预先创建线程的名称格式
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(2,3,10000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(3) ,
                (r,executor)->{
                    //把拒绝的任务记录日志,然后空闲时间解析再重新执行
                    System.out.println("当前被拒绝任务为：" + r.toString());
                    System.out.println("当前线程池大小为："+executor.getPoolSize());
//                    try {
//                        executor.getQueue().put(r);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    rejectTask.add(r);
                }
//                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i=1;i<=maxNum;i++){
            poolExecutor.execute(new Task("task---"+i));
        }


        System.out.println("需要继续执行的任务列表：");
        rejectTask.forEach(System.out::println);
//        rejectTask.forEach(task -> poolExecutor.execute(task));

        poolExecutor.shutdown();
    }


    /**
     * 内部task线程类
     */
    static class Task extends Thread{

        String taskName;
        Task(String taskName){
            super(taskName);
            this.taskName=taskName;
        }

        @Override
        public void run() {

            try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(17));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"----执行任务---"+taskName);
        }
    }
}
