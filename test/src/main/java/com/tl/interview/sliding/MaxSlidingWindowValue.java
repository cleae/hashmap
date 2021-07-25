package com.tl.interview.sliding;

public class MaxSlidingWindowValue {

    /**
     * 滑动窗口的最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new int [0];
        if(k==1)
            return nums;
        int length=nums.length;
        int result [] =new int [length-k+1];

        int front=0,real=k;
        int max=nums[0];
        for(int i=1 ;i<real;i++)
            max=max>nums[i]? max: nums[i];

        result[front++]=max;//先计算出0-k当中的最大值

        while(real<length){//每次后移一位比较最大值
            if(max==nums[front-1]){
                max=nums[front];
                for(int i=front+1 ;i<=real;i++)
                    max=max>nums[i]? max: nums[i];
            }
            else{
                if(nums[real]>max){
                    max=nums[real];
                }
            }
            result[front++]=max;
            real++;
        }
        return result;
    }
}
