package com.tl.main.other;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {


    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        if (strs.length == 0)
            return "";
        StringBuilder res = new StringBuilder();
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            boolean equals = true;
            for (int k = 1; k < strs.length; k++) {
                if (strs[k].length() <= i || strs[k].charAt(i) != str.charAt(i)) {
                    equals = false;
                }
            }
            if (equals) {
                res.append(str.charAt(i));
            }else{
                break;
            }
        }

        return res.toString();
    }

    /**
     *  nums = [-2,1,-3,4,-1,2,1,-5,4]
     *  输出: 6
     *  连续子数组最大的和  要求时间复杂度为O(n)。
     * @param nums
     */
    public static int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int res=nums[0];
//         =new int[nums.length];
        int dp[]=Arrays.copyOf(nums,nums.length);
        dp[0]=nums[0];
        for (int i = 1 ; i < nums.length; i++) {
                dp[i] += Math.max(dp[i-1], 0);
                res = Math.max(dp[i], res);
        }
        return res;
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res=0;
        Arrays.sort(boxTypes, (o1, o2) -> o1[1]-o2[1]);
        int index=boxTypes.length-1;
        while(truckSize >0 && index>=0 ){
            if(truckSize> boxTypes[index][0]){
                res +=boxTypes[index][0]* boxTypes[index][1];
                truckSize-=boxTypes[index][0];
            }else{
                res +=truckSize* boxTypes[index][1];
                truckSize-=0;
            }
            index--;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] t = new int[3][3];
//        String[] str = {"flower", "flow", "flight"};
        String[] str = {"cir","car"};
        System.out.println(longestCommonPrefix(str));
        int arr [] ={-2,1};
         System.out.println(maxSubArray(arr));
    }
}
