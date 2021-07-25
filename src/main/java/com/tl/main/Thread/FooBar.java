package com.tl.main.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private volatile  boolean flag=false;
    private ReentrantLock reentrantLock=new ReentrantLock();
    private Condition condition=reentrantLock.newCondition();


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try{
                reentrantLock.lock();
                while(flag){
                    condition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag=true;
                condition.signal();
            }finally {
                reentrantLock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try{
                reentrantLock.lock();
                while(!flag){
                    condition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag=false;
                condition.signal();
            }finally {
                reentrantLock.unlock();
            }

        }
    }



}
