package com.duan.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 可见性 问题
 * @author: wangruirui
 * @date: 2018/09/28
 */
public class VisableDemo {

    private static volatile boolean stop = false;
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            int i = 0;
            while(!stop){
                i++;

            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);

        stop = true;
    }

    // 标准的 可见性 问题，去掉 volatile 线程一般不会停掉

}
