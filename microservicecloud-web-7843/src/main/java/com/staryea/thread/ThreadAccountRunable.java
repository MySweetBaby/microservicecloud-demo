package com.staryea.thread;

/**
 * Created by tangdy on 2019/1/16.
 * synchronized 关键字 要保证锁是同一把锁 才能保证线程安全 锁可以是任意类
 * 实现Runnable接口可以使用this关键字来实现，原理：
 * 因为创建多个线程用的是同一个实例（只是new 一个ThreadAccountRunable类，然后调用Thread的有参构造方法创建线程）
 * 详情如下
 *
 * 线程通信：需要在同步中使用
 * wait(),是当前线程释放锁，让出cpu资源
 * notify().notifyAll() 唤醒线程，使线程获得cpu资源，notify()唤醒所有等待线程中优先级最高的线程，notifyAll()唤醒所有线程
 */
public class ThreadAccountRunable implements Runnable {

    private int count = 0;

    public void run() {
        for (int i = 0; i < 3; i++) {
//            synchronized (this){//静态代码块，将需要共享的数据放在静态代码块中，来保证线程的安全
//                count+=1000;
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"写入1000"+"账户余额:"+count);
//            }
            add();
        }
    }

    public synchronized void add() {//将关键字加载方法上，方法体中放的是需要共享的数据，来保证线程的安全
        notify();
        count += 1000;
        System.out.println(Thread.currentThread().getName() + "写入1000" + "账户余额:" + count);
        try {
            Thread.sleep(10);
            wait();
//            Thread.currentThread().notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ThreadAccountRunable account = new ThreadAccountRunable();
        Thread thread = new Thread(account);
        Thread thread1 = new Thread(account);
        thread.setName("张三");
        thread1.setName("李四");
        thread.start();
        thread1.start();
    }
}