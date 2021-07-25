package com.tl.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * description: InsertList
 * created by lintan at 2020/11/20 10:03
 */
public class InsertList {

      static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    /**
     * 链表直接插入排序
     * @param head
     * @return
     */
    static public ListNode insertionSortList(ListNode head){//4 2 2 1
        if(head==null || head.next==null)
            return head;
        ListNode right= head.next;
        ListNode left =head;
        ListNode real_head= head;
        while(right!=null){
            if(right.val>=left.val){
                right=right.next;
                left=left.next;
            }else{
                ListNode p_head= real_head;
                left.next=right.next;
                ListNode pre=null;
                while(p_head!=null){
                    if(p_head.val>right.val){
                        right.next=p_head;
                        if(p_head==real_head){
                            real_head=right;
                        }
                        if(null==left.next&&pre!=null){
                            pre.next=right;
                        }
                        right=left.next;
                        break;
                    }else{
                        pre=p_head;
                        p_head=p_head.next;
                    }
                }
            }
        }
        return real_head;
    }


    static public ListNode createLink(int [] arr){
        if(arr.length==1)
            return null;
        ListNode head= new ListNode(arr[0]);
        ListNode p=head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            p.next=node;
            p=node;
        }
        return head;
    }

    public static void main(String[] args) {
//        int [] arr= {4,2,2,1,0,543,3,6,3};
        int [] arr= {4,2,2,1};
        ListNode head = createLink(arr);
        ListNode res = insertionSortList(head);

        while(res!=null){
            System.out.print(res.val +"\t");
            res=res.next;
        }

    }
}
