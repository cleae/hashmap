package com.tl.main.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Foo2 {

    private CountDownLatch countDownLatch =new CountDownLatch(1);
    private CountDownLatch countDownLatch_third=new CountDownLatch(1);

    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            countDownLatch.countDown();

    }

    public void second(Runnable printSecond) throws InterruptedException {

            countDownLatch.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            countDownLatch_third.countDown();


    }

    public void third(Runnable printThird) throws InterruptedException {
            countDownLatch_third.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();


    }
}
