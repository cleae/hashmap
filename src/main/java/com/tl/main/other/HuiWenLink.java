package com.tl.main.other;

public class HuiWenLink {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 回文链表
     *      请判断一个链表是否为回文链表。 leetcode 234
     * @param head
     * @return
     */
    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }


    /**
     * 回文链表，空间复杂度O(1)
     *      快慢指针，反转后半部分链表，再进行比较
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if(null== head || head.next ==null)
            return true;

        ListNode slow=head;
        ListNode fast=head;
        ListNode pre_slow=null;
        while(fast!=null && fast.next!=null){
            pre_slow=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;
        ListNode curr=slow;
        ListNode pre=pre_slow;
        while(curr !=null){
            ListNode temp =curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        ListNode front=head;
        ListNode tail=pre;
        while(front!=mid){
            if(front.val!=tail.val){
                return false;
            }
            front=front.next;
            tail=tail.next;
        }
        return true;
    }
}
