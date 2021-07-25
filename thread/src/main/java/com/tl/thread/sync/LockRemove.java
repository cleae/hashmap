package com.tl.thread.sync;

public class LockRemove {


    /**
     * 锁消除
     *
     *     public synchronized StringBuffer append(int i) {
     *         toStringCache = null;
     *         super.append(i);
     *         return this;
     *     }
     * @param args
     */
    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < 100000000; i++) {//i是局部变量，多线程环境下不涉及对临界资源的操作
//            sb.append(i);
//        }

        int n=19;
        boolean tt= (n&n-1) ==0;
        System.out.println(-4&-1);
    }
}
