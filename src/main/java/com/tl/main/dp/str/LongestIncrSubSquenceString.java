package com.tl.main.dp.str;

import java.util.Deque;
import java.util.LinkedList;

public class LongestIncrSubSquenceString {

    /**
     * 最长递增子序列/最长上升子序列
     * @param nums
     * @return
     */
    static public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //dp[i] 表示前i个序列的最长增长的个数  int [] nums ={1,3,6,7,9,4,10,5,6};
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        // return dp[nums.length-1];
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+"\t");
        }
        return res;


        // int res=0;
        // int length=nums.length;
        // //dp[i][j]表示i到j之间最长递增子序列的长度
        // int dp [][] =new int [length][length];

        // for(int i=0; i<length; i++){
        //     int temp=nums[i];
        //     for(int j=i; j<length; j++){
        //         if(j==i){
        //             dp[i][j]=1;
        //         }else{
        //             if(nums[j]>temp){
        //                 dp[i][j]=dp[i][j-1]+1;
        //                 temp=nums[j];
        //             }else{
        //                 if(nums[i]<nums[j])
        //                     temp=nums[j];
        //                 dp[i][j]=Math.max(dp[i][j], dp[i][j-1]);
        //             }
        //         }
        //         res=Math.max(res,dp[i][j]);
        //     }
        // }

        // return res;
    }
    static public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //dp[i] 表示前i个序列的最长增长的个数  int [] nums ={1,3,6,7,9,4,10,5,6};
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
//            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        // return dp[nums.length-1];
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+"\t");
        }
        return res;}


    public static void main(String[] args) {
        int [] nums ={1,3,6,7,9,4,10,5,6};//[0,1,0,3,2,3]
//        int [] nums ={10,9,2,5,3,7,101,18};//[0,1,0,3,2,3]

        System.out.println("len:"+lengthOfLIS(nums));
        System.out.println("len:"+lengthOfLIS2(nums));
    }
}
