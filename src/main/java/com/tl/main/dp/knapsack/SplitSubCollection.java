package com.tl.main.dp.knapsack;


/**
 * 分割等和子集
 * @time 2020/11/11 created by lintan
 */
public class SplitSubCollection {

    /**
     * 转化成0 1背包问题
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {

        int length=nums.length;
        if(length<2)
            return false;
        int sum=0;
        for(int num : nums){
            sum+=num;
        }
        if((sum &1 )==1){//sum 为奇数，直接返回false
            return false;
        }

        int target=sum/2;
        //dp[i][j]表示前i个数字有没有和为j布尔类型结果
        boolean [][] dp =new boolean[length][target+1];

        if(nums[0]<target){//后一行得结果依赖前一行得结果，初始化第一行得结果，第一行只有自己本身得值为true;
            dp[0][nums[0]]=true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j]=dp[i-1][j];
                if(nums[i]==j){
                    dp[i][j]=true;
                    continue;
                }
                if(nums[i]<j){
                    //只需要前一行为true或者前一行的j-nums[i]处为true（意思就是j-sums[i] +sums[i]==j ,也就是当前nums[i]加入计算）
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[length-1][target];
    }
}
