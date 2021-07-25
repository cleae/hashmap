package com.tl.thread.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AqsTest {


    private static ReentrantLock lock = new ReentrantLock();

    private volatile  int count =0;

    public void consumer(){
        try {
            lock.lock();
            count++;
            System.out.println("得到锁。。。");
        }finally {
            lock.unlock();
            System.out.println("释放锁。。。。");
        }
    }

    /**
     * AQS底层原理
     *      AbstractQueuedSynchronizer
     *      参考:
     *          https://mp.weixin.qq.com/s/k3LJTKAmS5rOh67LOIwh6A
     *
     * @param args
     */
    public static void main(String[] args) {
        AqsTest aqsTest = new AqsTest();
        Thread thread1 = new Thread(() -> {
            aqsTest.consumer();
        },"thread-1");
        thread1.start();
        Thread thread2 = new Thread(() -> {
            aqsTest.consumer();
        }, " thread-2");
        thread2.start();

        System.out.println(1<<16);
    }
}
