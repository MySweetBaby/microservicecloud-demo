package com.staryea.thread;

/**
 * Created by tangdy on 2019/1/16.
 * 继承Thread 类的时候 如果要改变变量的值，就需要将变量设置为静态的，否则，创建多个线程的时候就会产生多个
 * 对象，就会存在多个变量，这样每个线程调用自己的变量，改变的是当前线程的变量，不会影响其他线程的变量，
 * 线程加锁的方式 也是使用静态来创建一个静态类作为锁。不能使用this关键字，因为继承Thread类是创建多个对象
 * （创建几个线程就创建几个对象）
 *
 */
public class ThreadAccountThread extends Thread {

    private static int count=0; //需要保证变量是静态的，这样才能保证不管创建多少对象，都只有一个变量

    private static Object object =new Object();//需要保证锁是静态的，这样才能保证不管创建多少对象，都只有一个锁（任意类）

    public void run(){
//        synchronized (object){//可以使用任意类作为锁，但是不能使用this关键字
//            count+=1000;
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"写入1000"+"账户余额:"+count);
//        }
        add();


    }

    public static synchronized void add(){ //要在方法上添加同步，需要将方法设置为静态方法。保证创建多个对象的时候只有一个方法
        count+=1000;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"写入1000"+"账户余额:"+count);
    }

    public static void main(String[] args) {
        ThreadAccountThread threadAccountThread =new ThreadAccountThread();
        ThreadAccountThread threadAccountThread1 =new ThreadAccountThread();
        threadAccountThread.setName("张三");
        threadAccountThread1.setName("李四");
        threadAccountThread.start();
        threadAccountThread1.start();
    }

}