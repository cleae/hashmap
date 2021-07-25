package com.tl.main.dp;

public class Robbery {

    /**
     * 打家劫舍 动态规划
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        if(nums.length ==1){
            return nums[0];
        }
        if(nums.length ==2){
            return nums[0]>nums[1] ?nums[0] :nums[1];
        }
        //dp[i] 表示偷前i间房子能偷窃到的最大金额
        //第i 间房子偷与不偷是个问题
        //偷 偷第i间房子的价值+前i-2间房子能偷盗的最大价值
        //不偷 前i间房子能偷到的最大价值
        //取偷与不偷能获取价值最大的那一个
        int length=nums.length;
        int dp [] =new int [length];
        dp[0]= nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for( int i=2 ;i<length; i++){
            dp[i]= Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[length-1];
    }


    /**
     * 打家劫舍 动态规划 +滚动数组
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        if(nums.length ==1){
            return nums[0];
        }
        if(nums.length ==2){
            return nums[0]>nums[1] ?nums[0] :nums[1];
        }
        //dp[i] 表示偷前i间房子能偷窃到的最大金额
        //第i 间房子偷与不偷是个问题
        //偷 偷第i间房子的价值+前i-2间房子能偷盗的最大价值
        //不偷 前i间房子能偷到的最大价值
        //取偷与不偷能获取价值最大的那一个
        int length=nums.length;

        int ppre= nums[0];
        int pre=Math.max(nums[0],nums[1]);
        for( int i=2 ;i<length; i++){
            int temp=Math.max(pre, ppre + nums[i]);//
            ppre=pre;
            pre=temp;
        }
        return pre;
    }
}
