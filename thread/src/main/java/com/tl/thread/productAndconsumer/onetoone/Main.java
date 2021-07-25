package com.tl.thread.productAndconsumer.onetoone;


import java.util.ArrayList;
import java.util.List;

/**
 * 生产者与消费者模型  一对一
 */
public class Main {

    private List<String> list = new ArrayList<>();

    public synchronized void product() {
        try {
            if (list.size() == 1) {//一生产一消费
                System.out.println("生产者阻塞。。。");
                this.wait();
            }
            String keyValue="number:" + Math.random();
            list.add(keyValue);
            this.notify();
            System.out.println("生产: "+keyValue+ "当前size"+ list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consumer() {
        try {
            if (list.size() == 0) {//一生产一消费
                System.out.println("消费者阻塞。。。");
                this.wait();
            }
            String remove = list.remove(0);
            this.notify();
            System.out.println("消费: "+remove+ "当前size"+ list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        consumer.start();
        product.start();
    }
}
