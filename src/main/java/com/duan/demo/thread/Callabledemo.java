package com.duan.demo.thread;

import java.util.concurrent.*;

/**
 * @Description:  带有返回值的 多线程
 * @author: wangruirui
 * @date: 2019/01/31
 */
public class Callabledemo implements Callable<String> {


    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callabledemo callabledemo = new Callabledemo();
        Future<String> kaka= executorService.submit(callabledemo);

        //可以在这里写别的逻辑

        try {
            System.out.println(kaka.get());//这个地方会阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

    }



    @Override
    public String call() throws Exception {
        String kaka = "wosha";
        return kaka;
    }
}
