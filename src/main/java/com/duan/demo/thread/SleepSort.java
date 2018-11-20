package com.duan.demo.thread;

/**
 * @Description:
 * @author: wangruirui
 * @date: 2018/11/20
 */
public class SleepSort implements Runnable {

    private String num;

    public SleepSort(String num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Integer.parseInt(num));
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{10,33,34,55,22,11};

        for (int i = 0; i <a.length ; i++) {
            new Thread(new SleepSort(a[i]+"")).start();

        }


    }
}
