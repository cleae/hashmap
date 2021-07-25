package com.tl.interview.start;

/**
 * description: SearchKey
 * created by lintan at 2020/12/7 19:05
 */
public class SearchKey {

    static public boolean searchMatrix(int[][] matrix, int target) {
        //二分查找
        for(int i=0; i<matrix.length; i++){
            boolean res=binarySearch(matrix[i],target);
            if(res){
                return true;
            }
        }
        return false;
    }

    //二分法迭代
    static public boolean binarySearch( int [] arrays, int target){
        int start=0;
        int end=arrays.length-1;//不减1，start<end;(会越界) 减一，start<=end。
        while(start<=end){
            int mid=(start+end)>>1;
            if(arrays[mid]==target){
                return true;
            }else if (arrays[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }

    //二分法递归
    static  public boolean binarySearch2( int [] arrays, int target,int start, int end){
        return true;
    }


    public static void main(String[] args) {

        int[][] matrix={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target=5;
        System.out.println(searchMatrix(matrix,target));

        int [] arr={2,5,8,12,19};
        System.out.println(binarySearch(arr,5));
    }
}
