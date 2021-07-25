package com.tl.main.other;

import java.util.HashMap;
import java.util.Map;


/**
 * 最近最少使用
 */
public class LRUCache {

    private int size;//双向链表的长度
    private int capacity;
    LRUNode tail;
    LRUNode head;
    Map<Integer, LRUNode> map;

    private static final int NOT_FOUND=-1;
    /**
     * LRU缓存初始化
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.size=0;
        this.capacity=capacity;
        tail=new LRUNode(-1,-1);
        head=new LRUNode(-1,-1);
        tail.pre=head;
        head.next=tail;
        map=new HashMap<>();
    }

    /**
     * 查询缓存
     *      未查到返回-1
     *      查到将该节点置为头结点并返回值
     * @param key
     * @return
     */
    public int get(int key) {
        if(!map.containsKey(key)){
            return NOT_FOUND;
        }
        LRUNode lruNode = map.get(key);
        //移动节点至头部
        removeNodeToHead(lruNode);
        return lruNode.value;
    }

    /**
     * 增加缓存
     *      key 不存在 创建一个新节点，插入双向链表的头部，判断size是否大于capacity ，大于删除链表尾部节点 和哈希表中对应的节点
     *      key 存在 先通过hash表定位，再更新value 将节点移到链表的头部
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        boolean containsKey = map.containsKey(key);
        if(containsKey){
            LRUNode lruNode = map.get(key);
            lruNode.value=value;
            //移动节点至头部
            removeNodeToHead(lruNode);
        }else{
            LRUNode lruNode = new LRUNode(key, value);
            lruNode.next=head.next;
            lruNode.pre=head;
            head.next=lruNode;
            lruNode.next.pre=lruNode;
            if(size==capacity){//删除链表尾
                System.out.println("移除表尾元素:" +tail.pre.key);
                map.remove(tail.pre.key);
                LRUNode pre= tail.pre.pre;
                tail.pre=tail.pre.pre;
                pre.next=tail;
                size--;
            }
            map.put(key,lruNode);
            size++;
        }
    }

    /**
     *  将给定链表节点移到链表头部
     * @param lruNode
     */
    public void removeNodeToHead(LRUNode lruNode){
        lruNode.pre.next=lruNode.next;
        lruNode.next.pre=lruNode.pre;

        LRUNode HEAD_NEXT=head.next;
        head.next=lruNode;
        lruNode.pre=head;

        lruNode.next=HEAD_NEXT;
        HEAD_NEXT.pre=lruNode;
    }

    /**
     * 双向链表
     */
    class LRUNode{
        int key;
        int value;
        LRUNode pre;
        LRUNode next;

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        int i = lRUCache.get(1);// 返回 1
//        System.out.println("result:" +i);
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        int i1 = lRUCache.get(2);// 返回 -1 (未找到)
//        System.out.println("result:" +i1);
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        int i2 = lRUCache.get(1);// 返回 -1 (未找到)
//        System.out.println("result:" +i2);
//        int i3 = lRUCache.get(3);// 返回 3
//        System.out.println("result:" +i3);
//        int i4 = lRUCache.get(4);// 返回 4
//        System.out.println("result:" +i4);


        //["LRUCache","put","put","put","put","get","get"]
        //[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);

        int i = lRUCache.get(1);// 返回 1
        System.out.println("result:" +i);
        int i1 = lRUCache.get(2);// 返回 -1 (未找到)
        System.out.println("result:" +i1);


    }

}