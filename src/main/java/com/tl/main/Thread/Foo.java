package com.tl.main.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {  //错误示例

    private ReentrantLock reentrantLock =new ReentrantLock();

    private Condition condition =reentrantLock.newCondition();

    private Condition condition_third =reentrantLock.newCondition();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            reentrantLock.lock();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            condition.signal();
        }finally {
            reentrantLock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            reentrantLock.lock();
            condition.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            condition_third.signal();
        }finally {
            reentrantLock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            reentrantLock.lock();
            condition_third.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }finally {
            reentrantLock.lock();
        }

    }
}
