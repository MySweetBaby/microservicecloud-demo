package com.staryea.thread;

/**
 * Created by tangdy on 2019/1/16.
 */
class MyRunable implements Runnable{
    int tickets=100;
    public void run() {
        while (true){
            if(tickets>0){
                System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets--+"张票");
            }else {
                return;
            }
        }
    }
}

public class MyThread extends Thread {

    private int count = 0;

    public synchronized void run() {
        int i = count--;
        if (i == 0) {
            return;
        } else {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在获取第" + i + "条数据");
        }
    }

    public static void main(String[] args) {
//        MyThread thread1 = new MyThread();
//        MyThread thread2 = new MyThread();
//        thread1.setName("线程1");
//        thread2.setName("线程2");
//        thread1.start();
//        thread2.start();
        MyRunable myRunable =new MyRunable();
        Thread w1= new Thread(myRunable);
        Thread w2= new Thread(myRunable);
        Thread w3= new Thread(myRunable);
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();

    }
}