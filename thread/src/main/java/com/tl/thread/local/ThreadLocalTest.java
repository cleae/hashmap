package com.tl.thread.local;

import java.util.List;

public class ThreadLocalTest {

    /**
     * ThreadLocal 内存泄露问题
     * Java中的引用类型有哪几种？
     *      强引用
     *          不会被垃圾回收
     *      软引用
     *          发生内存溢出之前会将这些对象进行回收
     *      弱引用
     *          只能活到下次垃圾回收器
     *      虚引用
     *          专门用来管理堆外内存的，当虚引用对象被回收的时候， 会放到reference query 队列里面，我们可以检测query ,然后清理堆外内存
     * 每种引用类型的特点是什么？
     *
     * 每种引用的应用场景是什么？
     *      强引用：普通用法
     *      软引用：适合做缓存， 内存够的时候一直常驻内存， 不够的时候直接被垃圾收集器回收掉
     *      弱引用：map 里面防止一些内存泄露， threadLocal里防止内存泄露
     *      虚引用： jvm内部用来管理直接内存
     * ThreadLocal 你了解吗？
     *      每个线程都享有一份对”共享变量“ 的拷贝， 用来解决线程安全的问题
     *
     * ThreadLocal 应用在什么地方
     *      Spring @Transaction  ThreadLocal<Connection> ,控制事务，每个线程都有一个connect
     *
     * ThreadLocal 使用不当会产生内存泄露你知道吗？
     *      每个Thread 都有一个 ThreadLocal.ThreadLocalMap threadLocals  成员对象
     *      threadLocal.set(T value) 实际上是在线程的threadLocals 变量set一个值 key是threadLocal
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        threadLocal.set(1);

        /**
         * 值继承   InheritableThreadLocal 可以让子线程继承父线程的值
         */


    }
    static {

    }

    static {

    }

}
