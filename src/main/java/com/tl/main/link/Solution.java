package com.tl.main.link;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        //快慢指针

        ListNode fast = head;
        ListNode slow = head;
        int index = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            index++;
        }
        int top = index % 2==1?index/2+1 :index/2;
        index = index / 2;
        while (index != 0) {
            fast = fast.next; //快指针先行
            index--;
        }
        ListNode[] stack = new ListNode[top];
        while (fast != null) {
            stack[index++] = fast;
            fast = fast.next;
        }
        //交换节点
        while (top > 0) {
            ListNode temp = stack[--top];
            if(slow==temp ){
                slow.next=null;
                break;
            }
            if(slow.next==temp){
                temp.next=null;
                break;
            }
            temp.next = slow.next;
            slow.next = temp;
            slow = temp.next;
        }
    }
    public static void main(String[] args) {
      //  ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);
        reorderList(node);

        System.out.println(1);
    }

}
