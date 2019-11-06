package com.staryea.thread;

/**
 * Created by tangdy on 2019/1/16.
 * 需要共享的数据要用synchronized 同步起来
 */

class Producer implements Runnable {

    Produter produter;

    Producer(Produter produter) {
        this.produter = produter;
    }

    public void run() {
        System.out.println("生产者开始生产产品");
        while (true) {
            produter.ProduceProduter();
        }
    }
}

class Consumer implements Runnable {

    Produter produter;

    Consumer(Produter produter) {
        this.produter = produter;
    }

    public void run() {
        System.out.println("消费者开始消费产品");
        while (true) {
            produter.reduceProduter();
        }

    }
}

class Produter {
    int count;

    public synchronized void ProduceProduter() {
        if (count >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "生产第" + count + "个产品。");
            notifyAll();
        }
    }

    public synchronized void reduceProduter() {
        if (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "消费第" + count + "个产品。");
            count--;
            notifyAll();
        }
    }

}

public class TestProducerConsumer {

    public static void main(String[] args) {
        Produter produter = new Produter();
        Producer producer = new Producer(produter);
        Consumer consumer = new Consumer(produter);
        Thread p1 = new Thread(producer);
        Thread p2 = new Thread(producer);
//        Thread p3= new Thread(producer);
        Thread c1 = new Thread(consumer);
        p1.setName("生产者1");
        p2.setName("生产者2");
        c1.setName("消费者1");
//        p2.start();
        c1.start();
        p1.start();

    }

}