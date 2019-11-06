package com.staryea.thread;

/**
 * Created by tangdy on 2019/1/16.
 * 产生死锁的条件，当前线程已经占用同步锁，需要另一个线程释放另一个锁，另一个线程也在等待当前线程释放锁
 * ，就导致死锁的产生
 */
public class ThreadDeadLock {

    private static StringBuffer sb1 =new StringBuffer();
    private static StringBuffer sb2 =new StringBuffer();

    public static void main(String[] args) {
        new Thread(){
            public void run(){
                synchronized(sb1){
                    sb1.append("A");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (sb2){
                        sb2.append("B");
                        System.out.println("sb1 is :"+sb1+" sb2 is :"+sb2);
                    }
                }
            }

        }.start();
        new Thread(){
            public void run(){
                synchronized(sb2){
                    sb1.append("C");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (sb1){
                        sb2.append("D");
                        System.out.println("sb1 is :"+sb1+" sb2 is :"+sb2);

                    }
                }
            }

        }.start();
    }

}