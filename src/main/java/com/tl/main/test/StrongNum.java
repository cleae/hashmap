package com.tl.main.test;

import java.util.Arrays;

public class StrongNum {


    public static int[] getStrongest(int[] arr, int k) {
        if(arr.length==0)
            return new int[0];
        if(arr.length==1|| arr.length==k)
            return arr;
        //排序
//        int j,temp;
////        for(int i=1;i<arr.length;i++){
////            if(arr[i-1]>arr[i]){
////                temp=arr[i];
////                for(j=i-1;j>=0&&arr[j]>temp;j--){
////                    arr[j+1]=arr[j];
////                }
////                arr[j+1]=temp;
////            }
////
////        }

        Arrays.sort(arr);
        int middle_index =(arr.length-1) >>>1;
        int middle= arr[middle_index];

        int [] result =new int [k];
        //从两头往中间比较
        int low=0,high=arr.length-1,index=0;
        while(low<=high&&index<k){
            if(Math.abs(arr[low]-middle)>Math.abs(arr[high]-middle)){
                result[index++]=arr[low];
                low++;

            }else if(Math.abs(arr[low]-middle)==Math.abs(arr[high]-middle)&&arr[low]>arr[high]){
                result[index++]=arr[low];
                low++;
            }else{
                result[index++]=arr[high];
                high--;
            }

        }
        return result;
    }

    public static void main(String[] args) {
//        int [] arr={6,7,11,7,6,8};
//        int [] arr={6,-3,7,2,11};
        int [] arr={-493,598,-262,-918,-76,-532,521};
        getStrongest(arr,7);
//        getStrongest(arr,3);

    }
}
