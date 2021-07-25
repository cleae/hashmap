package com.tl.thread.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;


/**
 * 如何利用 AQS 自定义一个互斥锁
 * AQS 通过提供 state 及 FIFO 队列的管理，为我们提供了一套通用的实现锁的底层方法，
 * 基本上定义一个锁，都是转为在其内部定义 AQS 的子类，调用 AQS 的底层方法来实现的，
 * 由于 AQS 在底层已经为了定义好了这些获取 state 及 FIFO 队列的管理工作，
 * 我们要实现一个锁就比较简单了，我们可以基于 AQS 来实现一个非可重入的互斥锁，
 * 如下所示
 */
public class Mutex {

    private Sync sync = new Sync();

    public void lock () {
        sync.acquire(1);
    }

    public void unlock () {
        sync.release(1);
    }

    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire (int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease (int arg) {
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively () {
            return getState() == 1;
        }
    }
}
