package com.duan.demo.thread;

import java.util.concurrent.*;

/**
 * @Description:
 * @author: wangruirui
 * @date: 2019/04/30
 */
public class ThreadPoolTest {

    private static final int corePoolSize = 2;
    private static final int maximumPoolSize = 4;
    private static final int keepAliveTime = 1000;
    private static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);

    public static void main(String[] args) {//创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, workQueue);
        for (int i = 0; i < 10; i++) {
            SendNoticeTask task = new SendNoticeTask();
            task.setCount(i);
            executor.execute(task);
        }
        System.out.println("主线程结束:" + Thread.currentThread().getName());



        ExecutorService executorService = Executors.newScheduledThreadPool(3);
    }


}


