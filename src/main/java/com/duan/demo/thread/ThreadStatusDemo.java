package com.duan.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 观察线程状态 demo  运行main 命令窗口 jps 找到进程id  运行命令 jstack id 查看各个状态
 * @author: wangruirui
 * @date: 2018/09/28
 */
public class ThreadStatusDemo {

    public static void main(String[] args){
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"timewaiting").start();

        new Thread(()-> {
            while(true){
                synchronized(ThreadStatusDemo.class){
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"waiting").start();

        new Thread(new BlockedDemo(),"blockedDemo-0").start();
        new Thread(new BlockedDemo(),"blockedDemo-1").start();

    }

    static class BlockedDemo extends Thread{

        public void run(){
            synchronized(BlockedDemo.class){
                while(true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }


}

