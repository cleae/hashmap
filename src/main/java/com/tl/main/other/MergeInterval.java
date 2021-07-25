package com.tl.main.other;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 合并区间 类似引爆气球
 */
public class MergeInterval {

    public int[][] merge(int[][] intervals) {

        //排序 + 贪心 类似引爆气球
        Arrays.sort(intervals, (p1, p2)->{return Integer.compare(p1[1],p2[1]);});
        List<List<Integer>> res = new ArrayList<>();

        int [] interval=intervals[0];
        int pre=0;
        for(int i=1 ; i<intervals.length; i++){
            if(intervals[i][0] <interval[1]){//不能合并
                List<Integer> item =new ArrayList<Integer>();
                if(pre!= i-1){
                    item.add(intervals[pre][0]);
                }else{
                    item.add(intervals[i][0]);
                }
                item.add(intervals[i][1]);
                res.add(item);
            }else{
                pre=i;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
