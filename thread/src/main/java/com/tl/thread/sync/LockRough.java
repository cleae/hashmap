package com.tl.thread.sync;

public class LockRough {

    StringBuffer stringBuffer = new StringBuffer();


    /**
     * 锁粗化
     *      多次对同一个对象加锁，这样的话，即使没有出现多线程竞争锁的情况，频繁进行同步互斥操作的开销也是很大的
     *      如果虚拟机检测到有一串零碎的操作都是对同一对象的加锁，将会把加锁同步的范围扩展（粗化）到整个操作序列的外部。
     */
    public void append(){
        stringBuffer.append("a");
        stringBuffer.append("b");
        stringBuffer.append("c");
    }

}
