package com.tl.main.other;

public class Link {

    static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    static public ListNode partition(ListNode head, int x) {
        if(null== head || null==head.next){
            return head;
        }
        ListNode slow=new ListNode(-1);//前置节点
        slow.next=head;
        ListNode fast=head;
        while(fast !=null &&fast.val != x){// 双指针，快指针指向分隔节点， 慢指针指向分隔节点的前一个节点
            if(slow.next.val<x){
                slow=slow.next;
            }
            fast=fast.next;
        }
        if(fast==null){//给定节点在链表中不存在
            return head;
        }
        System.out.print(slow.val);
        ListNode mid=fast;
        ListNode pre=fast;
        fast=fast.next;
        while(fast != null){
            ListNode next=fast.next;
            if(fast.val<mid.val){
                pre.next=fast.next;
                fast.next=slow.next;
                if(slow.next ==head){
                    head=fast;
                }
                slow.next=fast;
                slow=fast;
            }else{
                pre=fast;
            }
            fast=next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(2);
        node.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        partition(node,-1);

//        ListNode node = new ListNode(3);
//        ListNode node = new ListNode(3);
//        ListNode node = new ListNode(3);
    }
}
