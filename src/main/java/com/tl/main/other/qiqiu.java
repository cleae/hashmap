package com.tl.main.other;

import java.util.Arrays;

public class qiqiu {

    static public int findMinArrowShots(int[][] points) {
        if(points.length<=1){
            return points.length;
        }

        //按坐标结束位置排序，可以引爆最多气球
        Arrays.sort(points, (p1,p2)->{return Integer.compare(p1[1],p2[1]);});

        int length=points.length;
        int res =1;
        //两个区间有相交即可射穿

        int []point=points[0];

        for( int i=0 ;i<length ;i++){
            //没有相交,射穿前i个,res++
            if(points[i][0]>point[1]){
                res++;
                point=points[i];
            }

        }
        return res;

//        if(points.length < 1) return 0;
//        Arrays.sort(points, (a, b) -> (a[1] - b[1]));
//        int count = 1;
//        int axis = points[0][1];
//
//        for(int i = 1; i < points.length; ++i) {
//            if(axis < points[i][0]) {
//                count++;
//                axis = points[i][1];
//            }
//        }
//
//        return count;

    }


    public static void main(String[] args) {
        int [] [] points={
                {3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(findMinArrowShots(points));
    }
}
