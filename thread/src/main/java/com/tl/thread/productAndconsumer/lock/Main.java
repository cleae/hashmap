package com.tl.thread.productAndconsumer.lock;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者与消费者模型  多对多
 */
public class Main {

    private List<String> list = new ArrayList<>();
    private Lock lock=new ReentrantLock();
    private Condition condition= lock.newCondition();
    public  void product() {
        try {
            lock.lock();
            while (list.size() > 3) {//一生产一消费
                System.out.println("生产者阻塞。。。");
                condition.await();
            }
            String keyValue="number:" + Math.random();
            list.add(keyValue);
            condition.signalAll();
            System.out.println("生产: "+keyValue+ "当前size"+ list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public synchronized void consumer() {
        try {
            lock.lock();
            while (list.size() <= 0) {//一生产一消费
                System.out.println("消费者阻塞。。。");
                condition.await();
            }
            String remove = list.remove(0);
            condition.signalAll();
            System.out.println("消费: "+remove+ "当前size"+ list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    static class Consumer extends  Thread{
        private Main stock;

        public Consumer(Main stock) {
            this.stock = stock;
        }

        @Override
        public void run() {
            super.run();
            while(true){
                stock.consumer();
            }

        }
    }

    static class Product extends  Thread{
        private Main stock;

        public Product(Main stock) {
            this.stock = stock;
        }

        @Override
        public void run() {
            super.run();
            while(true){
                stock.product();
            }
        }
    }

    public static void main(String[] args) {
        Main stock = new Main();
        Consumer consumer = new Consumer(stock);
        Product product = new Product(stock);
        Consumer consumer2 = new Consumer(stock);
        Product product2 = new Product(stock);
        Consumer consumer3 = new Consumer(stock);
        Product product3 = new Product(stock);
        Consumer consumer4 = new Consumer(stock);
        Product product4 = new Product(stock);
        Consumer consumer5 = new Consumer(stock);
        Product product5 = new Product(stock);
        consumer.start();
        product.start();
        consumer2.start();
        product2.start();
        consumer3.start();
        product3.start();
        consumer4.start();
        product4.start();
        consumer5.start();
        product5.start();
    }
}
