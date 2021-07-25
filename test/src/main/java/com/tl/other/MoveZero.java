package com.tl.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * description: MoveZero
 * created by lintan at 2020/11/19 14:40
 *
 * leetcode-283 移动零
 */
public class MoveZero {


    //移动零 [0,0,1]
    static public void moveZeroes(int[] nums) { //错误,无法解决类似[0,0,1]的输入
        if(nums.length==1)
            return ;
        int len=nums.length;
        for (int i = 0; i <len ; i++) {
            if(nums[i]==0){
                int j=i+1;
                for (; j < len; j++) {
                    nums[j-1]=nums[j];
                }
                nums[j-1]=0;
            }
        }
    }


    /**
     * 双指针思路  时间复杂度O(N) 空间复杂度O(1)
     * @param nums
     */
    static public void moveZeroes2(int[] nums) {
        if(nums.length==1)
            return ;
        int len=nums.length;
        int left=0,right=0;

        //左右指针先都指向第一零的位置
        for (int i = 0; i < len; i++) {
            if(nums[i]!=0){
                left++;right++;
            }else {
                break;
            }
        }
        //right指针一直指向不为零的位置,left指针一直指向为零的位置
        while (right<len){
            if(nums[right]!=0){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
            }
            right++;

        }
    }


    public static void main(String[] args) {
//        int [] arr= {0,0,0,0,0,1};
        int [] arr= {0,1,0,3,12};
//        moveZeroes(arr);
        moveZeroes2(arr);
        for(int i:arr){
            System.out.print(i+"\t");
        }
    }
}
