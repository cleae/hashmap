package com.tl.jvm;

import java.util.ArrayList;

/**
 * jvm参数 ： -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    private byte [] bytes = new byte[1024 * 1024]; // 1MB

    public static void main(String[] args) {
        ArrayList<HeapOOM> list = new ArrayList<>();

        int count=0;

        try {
            while(true){
                list.add(new HeapOOM());
                count++;
            }
        }catch (Throwable e){
            System.out.println("count : " + count);
            e.printStackTrace();
        }
    }

}
