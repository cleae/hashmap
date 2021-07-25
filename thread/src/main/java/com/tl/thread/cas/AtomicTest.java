package com.tl.thread.cas;


import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * cas底层原理
 *  乐观锁和悲观锁是两种思想，用于解决并发场景下的数据竞争问题。
 *
 *      乐观锁：
 *          乐观锁在操作数据时非常乐观，认为别人不会同时修改数据。因此乐观锁不会上锁，
 *          只是在执行更新的时候判断一下在此期间别人是否修改了数据：如果别人修改了数据则放弃操作，否则执行操作。
 *     悲观锁：
 *          悲观锁在操作数据时比较悲观，认为别人会同时修改数据。因此操作数据时直接把数据锁住，
 *          直到操作完成后才会释放锁；上锁期间其他人不能修改数据。
 *  tested by lintan 2020/12/17
 */
public class AtomicTest {

    /**
     * CAS 的思想：三个参数，
     *      一个当前内存值 V、旧的预期值 A、即将更新的值 B，
     *      当且仅当预期值 A 和内存值 V 相同时，将内存值修改为 B 并返回 true，否则什么都不做，并返回 false。
     */

    //cas 的compareAndSwap 操作由硬件层面来保证原子性
        //cpu的缓存一致性协议
            //1 、总线加锁，同一时间数据只能被一个cpu操作
            //2、 缓存一致性协议，窥探技术+MESI协议  （解决多核cpu时代，缓存不一致的问题）
                //      窥探技术的基本思想：
                            //所有的内存数据传输都发生在一条共享的总线上，所有cpu都能看到这条cpu总线，cpu的缓存不停的窥探总线上的数据交换
                //当一个cpu的缓存要去读写内存的时候，其他cpu都会得到通知，以此来保证使自己的缓存保持同步，例如：
                        //一个cpu去写内存，其他cpu会马上知道这块内存在他们的缓中对应的缓存行已经失效
            //Modified ：已修改，
                //该缓存行已经被所属的cpu修改了
            //Exclusive: 独占
                //和S状态一样，缓存行的内容也是和主内存内容保持一致的一份拷贝，如果其他CPU原本也持有同一缓存行，那么它会马上变成“失效”状态（I状态）
            //Share :共享
                //cpu缓存中的缓存行的内容与主内存中的内容保持一致，该状态下缓存行只能被读取不能被写入，多组缓存可以同时拥有针对同一内存地址的共享缓存行
            //Invalid :失效
                //cpu缓存中没有该行缓存，或者缓存中的缓存行已经失效

            //缓存一致性协议总结：
            //缓存行只有在处于M ,E状态下，cpu才能去执行写操作，当cpu想写某个缓存行的时候，就必须发送一条：“我要独占某个内存空间”的请求
            //给总线，这个时候，其他cpu拥有的这块内存空间对应的缓存行就会立即失效，其他cpu要想重新读取这个缓存行,就必须等到被独占的缓存行重新回到"共享状态"

        AtomicInteger atomicInteger=new AtomicInteger(1);

    /**
     * Atomic 开头的原子类的原子操作底层都是由CAS操作完成的
     *
     * public final int getAndAddInt(Object var1, long var2, int var4) {
     *         int var5;
     *         do {
     *             var5 = this.getIntVolatile(var1, var2);获取var1 在var2上的偏移量
     *         } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4)); //cas操作不成功则一致自旋，知道成功为止
     *
     *         return var5;
     *     }
     */
    public void test (){
            atomicInteger.getAndDecrement();
    }

    // 初始值为1，版本号为0  jdk AtomicStampedReference 加入stamp版本号解决CAS多线程环境下面的ABA问题
    //从AtomicStampedReference的compareAndSet 方法得知，如果要更改内存中的值，不但要值相同，还要版本号相同。
    private static AtomicStampedReference<Integer> a = new AtomicStampedReference<>(1, 0);

    // 计数器
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("线程名字：" + Thread.currentThread() + ", 当前 value = " + a.getReference());
            // 获取当前版本号
            int stamp = a.getStamp();
            System.out.println("线程1 版本号为:" + stamp);
            // 计数器阻塞，直到计数器为0，才执行
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("线程名字：" + Thread.currentThread() + ",CAS操作结果: " + a.compareAndSet(1, 2, stamp, stamp + 1));
            System.out.println("线程1执行CAS操作之后 版本号为:" + a.getStamp());
            }, "线程1").start();

        // 线程2
        new Thread(() -> {
            // 将 value 值改成 2
            System.out.println("线程2 版本号为:" + a.getStamp());
            a.compareAndSet(1, 2, a.getStamp(), a.getStamp() + 1);
            System.out.println("线程名字" + Thread.currentThread() + "value = " + a.getReference());
            // 将 value 值又改成 1
            a.compareAndSet(2, 1, a.getStamp(), a.getStamp() + 1);
            System.out.println("线程名字" + Thread.currentThread() + "value = " + a.getReference());
            System.out.println("线程2 执行CAS操作之后 版本号为:" + a.getStamp());
            // 线程计数器
            countDownLatch.countDown();
        }, "线程2").start();
//        new ArrayList<Integer>().stream().reduce(Integer::sum).ifPresent();get();
    }
}
