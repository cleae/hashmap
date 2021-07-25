package com.tl.main.link;

import java.util.ArrayList;
import java.util.List;

public class Cycle {

     class ListNode {
         int val;
         ListNode next;
          ListNode(int x) {
              val = x;
             next = null;
          }
      }


    /**
     * 判断链表是否成环
     * 时间复杂度O(N) 空间复杂度O(N)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        List<ListNode> nodes=new ArrayList<>();

        ListNode p=head;
        boolean res=false;
        while(p!=null){
            if(nodes.contains(p)){
                res=true;
                break;
            }
            nodes.add(p);
            p=p.next;
        }
        return res;
    }

    /**
     * 优化空间复杂度 为O(1)   快慢指针
     * 快指针先行一步，至此快指针每次走两步。慢指针每次走一步，如果有环，则快慢指针会相遇
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {

        if(head==null || head.next==null)
            return false;
        ListNode fast=head.next;
        ListNode slow=head;

        while (fast != slow) {
            fast=fast.next;
            if(fast==null || fast.next==null)
                return false;
            else
                fast=fast.next;
            slow=slow.next;
        }

        return true;
    }

}
