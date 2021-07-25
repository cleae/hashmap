package com.tl.main.other;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class ThreeNumberTotal {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res =new ArrayList<List<Integer>>();
        List<Integer> item =new ArrayList<>();
        int target=0;
        int start=0;
        Arrays.sort(nums);
        //超时 leetcode 315 / 318 个通过测试用例
        dfs(res, nums, target, start,item);
        return res;
    }

    public void dfs(List<List<Integer>> res, int nums[] , int target, int start, List<Integer> item){
        if(item.size()==3 &&target ==0){
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for(int i=start ; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            if(item.size()>3){
                break;
            }
            item.add(nums[i]);
            dfs(res,nums,target-nums[i],i+1 ,item);
            item.remove(item.size()-1);
        }
    }



    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res =new ArrayList<List<Integer>>();
        //排序 +双指针
        if(nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        int length=nums.length;

        for (int i = 0; i < length; i++) {
            //去除重复的答案
            if(i==0 || nums[i-1]!= nums[i]){
                int left=i+1;
                int right=length-1;
                int target=-nums[i];
                while(left<right){
                    if(left>i+1 && nums[left]== nums[left-1]){
                        left++;
                        continue;
                    }
                    int total=nums[left] +nums[right];
                    if(total == target){
                        ArrayList<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[left]);
                        item.add(nums[right]);
                        res.add(item);
                        left++;//相等依旧往前移
                    }else if(total < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }

        }
        return res;
    }
}
