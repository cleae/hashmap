package com.tl.other;

/**
 * description: Gasoline
 * created by lintan at 2020/11/19 10:50
 *leetcode-114
 */
public class Gasoline {

    static public int canCompleteCircuit(int[] gas, int[] cost) {

        int start=0;
        int length=gas.length;

        for(;start<length; start++){
            int gasoline=0;
            int j=start;
            int temp=0;
            boolean flag=true;
            for(;temp<length;j++,temp++){
                gasoline+=gas[j%length];
                gasoline-=cost[j%length];
                if(gasoline<0){
                    flag=false;
                    break;
                }
            }
            if(flag)
                return start;
        }

        return -1;
    }


    public static void main(String[] args) {
        //[4,5,2,6,5,3]
        //[3,2,7,3,2,9]
        int []gas={1,2,3,4,5};
        int [] cost={3,4,5,1,2};
//        int []gas={4,5,2,6,5,3};
//        int [] cost={3,2,7,3,2,9};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
