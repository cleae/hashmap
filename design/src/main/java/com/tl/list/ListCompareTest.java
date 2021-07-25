package com.tl.list;

import java.util.*;
import java.lang.Class;

/*
 * @desc 对比ArrayList和LinkedList的插入、随机读取效率、删除的效率
 *
 * @author skywang
 */
public class ListCompareTest {

    private static final int COUNT = 1000000;

    private static LinkedList linkedList = new LinkedList();
    private static ArrayList arrayList = new ArrayList();
    private static Vector vector = new Vector();
    private static Stack stack = new Stack();


    /**
     * Stack : insert 1000000 elements into the 1st position use time：60221 ms
     * Vector : insert 1000000 elements into the 1st position use time：64783 ms
     * LinkedList : insert 1000000 elements into the 1st position use time：67 ms
     * ArrayList : insert 1000000 elements into the 1st position use time：60409 ms
     *
     * Stack : read 1000000 elements by position use time：22 ms
     * Vector : read 1000000 elements by position use time：23 ms
     * LinkedList : read 1000000 elements by position use time：936160 ms
     * ArrayList : read 1000000 elements by position use time：5 ms
     *
     * Stack : delete 1000000 elements from the 1st position use time：59261 ms
     * Vector : delete 1000000 elements from the 1st position use time：59176 ms
     * LinkedList : delete 1000000 elements from the 1st position use time：17 ms
     * ArrayList : delete 1000000 elements from the 1st position use time：59377 ms
     * @param args
     */
    public static void main(String[] args) {
        // 换行符
        System.out.println();
        // 插入
        insertByPosition(stack) ;
        insertByPosition(vector) ;
        insertByPosition(linkedList) ;
        insertByPosition(arrayList) ;

        // 换行符
        System.out.println();
        // 随机读取
        readByPosition(stack);
        readByPosition(vector);
        readByPosition(linkedList);
        readByPosition(arrayList);

        // 换行符
        System.out.println();
        // 删除
        deleteByPosition(stack);
        deleteByPosition(vector);
        deleteByPosition(linkedList);
        deleteByPosition(arrayList);
    }

    // 获取list的名称
    private static String getListName(List list) {
        if (list instanceof LinkedList) {
            return "LinkedList";
        } else if (list instanceof ArrayList) {
            return "ArrayList";
        } else if (list instanceof Stack) {
            return "Stack";
        } else if (list instanceof Vector) {
            return "Vector";
        } else {
            return "List";
        }
    }

    // 向list的指定位置插入COUNT个元素，并统计时间
    private static void insertByPosition(List list) {
        long startTime = System.currentTimeMillis();

        // 向list的位置0插入COUNT个数
        for (int i=0; i<COUNT; i++)
            list.add(0, i);

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : insert "+COUNT+" elements into the 1st position use time：" + interval+" ms");
    }

    // 从list的指定位置删除COUNT个元素，并统计时间
    private static void deleteByPosition(List list) {
        long startTime = System.currentTimeMillis();

        // 删除list第一个位置元素
        for (int i=0; i<COUNT; i++)
            list.remove(0);

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : delete "+COUNT+" elements from the 1st position use time：" + interval+" ms");
    }

    // 根据position，不断从list中读取元素，并统计时间
    private static void readByPosition(List list) {
        long startTime = System.currentTimeMillis();

        // 读取list元素
        for (int i=0; i<COUNT; i++)
            list.get(i);

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : read "+COUNT+" elements by position use time：" + interval+" ms");
    }
}