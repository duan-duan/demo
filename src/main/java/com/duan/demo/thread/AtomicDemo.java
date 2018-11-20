package com.duan.demo.thread;


/**
 * @Description: 原子性
 * @author: wangruirui
 * @date: 2018/09/28
 */
public class AtomicDemo {

    private static int count = 0;

    public void inrc(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i < 1000;i++ ){

            new Thread(new AtomicDemo()::inrc).start();
        }

        Thread.sleep(4);

        System.out.println("运行结果:"+count);
    }


}
