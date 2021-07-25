package com.tl.main.sub;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * */
public class Sub {

    public static List<List<Integer>> subsets(int[] nums) {


        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {

            //遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }


    public static List<List<Integer>> subsets2(int[] nums) {


        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {


            for (int j = 0; j <= i; j++) {

                List<Integer> list=new ArrayList<>();
                list.add(nums[j]);
                res.add(list);
            }


        }


        return res;
    }

    public static void main(String[] args) {


        int [] nums={1,2,3};

        subsets(nums);

    }

}
