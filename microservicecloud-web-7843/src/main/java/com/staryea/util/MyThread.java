package com.staryea.util;

/**
 * Created by tangdy on 2019/1/16.
 */
public class MyThread implements Runnable {

    private int count = 0;

    public void run() {
        for (int i = 0; i < 3; i++) {
            synchronized (this) {
//                System.out.println("写入前账户余额：" + count);
                count += 1000;
//                System.out.println(Thread.currentThread().getName() + "写入1000");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"写入后账户余额：" + count);
            }
        }

    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread account = new Thread(myThread);
        Thread account1 = new Thread(myThread);
        account.start();
        account1.start();
    }
}