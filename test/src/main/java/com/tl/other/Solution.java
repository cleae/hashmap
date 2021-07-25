package com.tl.other;

public class Solution {

    static public int countTriplets (int[] arr, int a, int b) {
        /*if(arr.length<3){
            return 0;
        }
        int res=0;

        for( int i=0; i<arr.length-2;i++){
            for( int j=i+1; j<arr.length-1; j++){
                for(int k=j+1; k<arr.length; k++){
                    if(Math.abs(arr[i]-arr[j])<=a &&Math.abs(arr[j]-arr[k])<=b){
                        System.out.println("enter...");
                        res=(res+1)%1000000007;
                    }
                }
            }
        }
        return res;*/

        int ret = 0;
        for(int j = 1; j< arr.length;j++){
            int sa = 0;
            int sb = 0;
            for(int i = j - 1; i >= 0; i--){
                if (Math.abs(arr[i] - arr[j]) <= a){
                    sa++;
                }
            }
            for(int i = j + 1; i<arr.length; i++){
                if (Math.abs(arr[i] - arr[j]) <= b){
                    sb++;
                }
            }
            ret += sa * sb;
            ret %= 1000000007;
        }
        return ret;
    }
    static public boolean check(int[] nums) {

        int length = nums.length;
        if(length<2){
            return true;
        }

        for( int i=0 ; i< length ; i++){
            int pre =nums[i];
            for(int j=i+1, count=0 ; count<length-1; j++,count++){
                int j2= j%length;
                if(nums[j2]<pre){
                    break;
                }
                if(count==length-2){
                    return true;
                }
                pre =nums[j2];
            }
        }
        return false;
    }



    public static void main(String[] args) {
//        int arr[] ={7,1,8,9,0,6,3,6,8,9,2,0,3,7,9,3,8,2,8,2,8,2,8,3,8,3,7,1,2,4,6,9};
//        long start=System.currentTimeMillis();
//        System.out.println(countTriplets(arr,3,3));
//        long end=System.currentTimeMillis();
//        System.out.println(end-start);
        int arr[] ={3,4,5,1,2};
        check(arr);
    }
}
