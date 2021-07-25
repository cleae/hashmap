package com.tl.main;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
//    transient    private  int password;  aware




//    Hashtable
//    ConcurrentHashMap
//    Object
    private static volatile  int index=0;

    private static int [] arrays={7,8,8,1,2,9,0};

    public static void input_array(){

        if(index<arrays.length){
            synchronized (HashMapTest.class){
                if(index<arrays.length)
                System.out.println(Thread.currentThread().getName()+"输出了："+arrays[index++]);
            }
        }
    }

    public static void main(String[] args) {
      /*  for (int i = 0; i < 10; i++) {

            new Thread(()->{
                input_array();
            }).start();
        }*/

        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    input_array();
                }
            }).start();
        }
//        ByteBuffer.all
        /**
         * jdk1.7 中hashMap 详细学习
         * 底层结构：
         *      数组+ 链表  Entry<K,V>[] table
         *问题一: 计算hash key的hashcode 与数组长度进行取模运算 indexFor()
         *
         * static int indexFor(int h, int length) {// N mod 2 的幂次方 == N &（2 的幂次方 -1）
         *         // assert Integer.bitCount(length) == 1 : "length must be a non-zero power of 2";
         *          *         return h & (length-1);
         *     }
         *
         *问题二:初始化数组的时候，容量为什么要是2的幂次方数
         *
         *       private static int roundUpToPowerOf2(int number) {//给定一个number 返回大于这个数的最小 2的幂次方
         *         // assert number >= 0 : "number must be non-negative";
         *         return number >= MAXIMUM_CAPACITY
         *                 ? MAXIMUM_CAPACITY
         *                 : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
         *     }
         *
         *     此处关键代码:
         *         public static int highestOneBit(int i) { //给定一个数，返回小于这个数的最大的2的幂次方数
         *         // HD, Figure 3-1
         *         i |= (i >>  1);
         *         i |= (i >>  2);
         *         i |= (i >>  4);
         *         i |= (i >>  8);
         *         i |= (i >> 16);
         *         return i - (i >>> 1);
         *     }
         *      System.out.println(Integer.highestOneBit(7));//4
         *      System.out.println(Integer.highestOneBit(16));//16
         *      System.out.println(Integer.highestOneBit(19));//16
         *
         *      Integer.highestOneBit(14)
         *
         *      0000 0000 0000 1110
         *           右移一位  0000 0000 0000 0111
         *                     0000 0000 0000 1110  或运算
         *                     0000 0000 0000 1111
         *      0000 0000 0000 1111
         *           右移两位  0000 0000 0000 0011
         *                     0000 0000 0000 1111  或运算
         *                     0000 0000 0000 1111
         *      0000 0000 0000 1111
         *            右移四位  0000 0000 0000 0000
         *                      0000 0000 0000 1111  或运算
         *                      0000 0000 0000 1111
         *      右移八位、右移十六位之后再按位或都是一样的了
         *
         *      return i - (i >>> 1);  返回 0000 0000 0000 1000
         *      最终返回 8
         *
         *      static final int MAXIMUM_CAPACITY = 1 << 30; //最大容量
         *
         *      总结:
         *          要想返回小于一个数得最大2的幂次方数  将这个数 从左至右起第一个为1 的比特位的数的低位都置零即可
         *          例子 14
         *          0000 0000 0000 1110 ----> 0000 0000 0000 1000
         *
         *          而这一段不断右移并与自身或运算的操作就是在把
         *                  0000 0000 0000 1110 ----> 0000 0000 0000 1111
         *                  再举一个例子，把33 0000 0000 0010 0001 ----> 0000 0000 0011 1111
         *          最后 return i - (i >>> 1);
         *
         *          知道了jdk源码怎么将给定一个数返回大于这个数的最小的2的幂次方数
         *          再回到问题二：
         *                  初始化数组的时候，容量为什么要是2的幂次方数？？
         *                  结合问题一，在通过key 的hashcode算key 的下标的时候用到了 hash & (length-1) 其实就是取hashcode 得低 log2^length 位得值
         *                      只有当length 为2得幂次方得时候，才能得到我们想要的值，说白了就是设计好的
         *
         *问题三:
         *      为什么hashMap
         *
         *
         *
         */
        Map<String,Object> map=new HashMap<String, Object>(8);

        map.put("1","2");

        System.out.println(Integer.highestOneBit(7));//4
        System.out.println(Integer.highestOneBit(16));//16
        System.out.println(Integer.highestOneBit(19));//16


        System.out.println(1<<30);
        System.out.println(2<<29);

        System.out.println((1<<31)-1);
        System.out.println(Integer.MAX_VALUE);


        System.out.println(true^false);

    }



}
