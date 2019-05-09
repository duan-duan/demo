package com.duan.demo.thread;

/**
 * @Description:
 * @author: wangruirui
 * @date: 2019/04/30
 */
public class SendNoticeTask implements Runnable {
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start to" + " send " + count + " ...");
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish " + Thread.currentThread().getName());
    }
}
