package com.tl.main.dp;

import java.util.Arrays;

public class SubArray {

    /**
     *  nums = [-2,1,-3,4,-1,2,1,-5,4]
     *  输出: 6
     *  连续子数组最大的和  要求时间复杂度为O(n)。
     * @param nums
     */
    @SuppressWarnings("all")
    public static int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int res=nums[0];
        //dp[i] 表示连续前i个数组的最大的和
        int dp[]= Arrays.copyOf(nums,nums.length);
        dp[0]=nums[0];
        for (int i = 1 ; i < nums.length; i++) {
            dp[i] += Math.max(dp[i-1], 0);
            res = Math.max(dp[i], res);
        }
        return res;
    }
    //给出一个数组，求连续大于给定数字的个数
    public static int maxSubArray(int[] nums,int number) {
        if(nums.length==1){
            return nums[0];
        }
        //dp[i] 表示前i个数组大于给定数字的个数
        int dp[]= new int[nums.length];

        dp[0]=nums[0]>number? 1:0;
        for (int i = 1 ; i < nums.length; i++) {
            if(nums[i]>number){
                dp[i]=Math.max(dp[i-1]+1, 1);
            }else {
                dp[i]=Math.max(dp[i-1], 0);
            }
        }
        return dp[nums.length-1];
    }


    //"anagram"
    //"nagaram" leetcode 242
    static public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        for(int i=0 ; i<s.length() ;i++){
            if(s.charAt(i)!=t.charAt(i)){
                for( int j=i+1 ;j<s.length();  ){
                    if(s.charAt(i)==t.charAt(j)&&s.charAt(j)==t.charAt(i)){
                        i++;
                        break;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }


    static public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int []s_arr=new int[26];
        int [] t_arr=new int[26];
        for (int i = 0; i < s.length(); i++) {
            s_arr[s.charAt(i)-97]++;
            t_arr[t.charAt(i)-97]++;
        }
        for (int i = 0; i < s_arr.length; i++) {
            if(s_arr[i]!=t_arr[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int arr[] ={3,5,0,3,2,1,4,7,5,8};
        System.out.println(maxSubArray(arr, 3));
        //"abdc"
        //"dbac"
        System.out.println(isAnagram2("nl", "cx"));


        System.out.println((int)'n');
        System.out.println((int)'l');
        System.out.println((int)'c');
        System.out.println((int)'x');
        System.out.println((int)'a'-97);


    }
}
