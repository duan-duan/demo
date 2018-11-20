package com.duan.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 线程停止
 * @author: wangruirui
 * @date: 2018/09/28
 */
public class InterruptDemo {
    private static int i;
    public static void main(String[] args){
        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                i++;
            }

            System.out.println(i);


        },"interrupDemo");
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();  //中断标志

    }
}
