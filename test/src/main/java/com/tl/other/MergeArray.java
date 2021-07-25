package com.tl.other;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * description: MergeArray
 * created by lintan at 2020/11/27 17:42
 * leetcode 88
 */
public class MergeArray {


    /**
     * 合并有序数组   双指针/从前往后 需要额外申请内存空间
     * @param nums1 目标数组
     * @param m
     * @param nums2
     * @param n
     */
    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length==0){
            return ;
        }
        int []nums1_copy=new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);

        int p1=0;
        int p2=0;
        int index=0;
        while(p1<m && p2<n){
            nums1[index++]=nums1_copy[p1]>nums2[p2]? nums2[p2++]:nums1_copy[p1++];
        }
        while(p1<m){
            nums1[index++]=nums1_copy[p1++];
        }
        while(p2<n){
            nums1[index++]=nums2[p2++];
        }

    }

    // 双指针/从后往前   不需要额外申请内存空间
    // int num1 [] ={1,2,3,0,0,0};
    // int num2 [] ={2,5,6};
    static public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length==0){
            return ;
        }
        int p1=m-1;
        int p2=n-1;
        int index=nums1.length-1;
        while(p1>=0 && p2>=0){
            nums1[index--]=nums1[p1]>nums2[p2]? nums1[p1--]:nums2[p2--];
        }
        while(p2>=0){
            nums1[index--]=nums2[p2--];
        }

    }



    static public String Probability (int n) {
        // write code here
        if(n<=1)
            return "1.00";
        if(n==2)
            return "0.50";
        double res=1;
        for(int i=0; i<n;i++){
            res*=0.5;
        }
        res+=res;
        String str=String.valueOf(res+0.005);
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < 4; i++) {
            builder.append(str.charAt(i));
        }
        return builder.toString();

    }


    public static void main(String[] args) {
        int num1 [] ={1,2,3,0,0,0};
        int num2 [] ={2,5,6};
        merge(num1,3,num2,3);
        merge2(num1,3,num2,3);
        for(int i: num1){
            System.out.println(i  +"\t");
        }

    }
}
