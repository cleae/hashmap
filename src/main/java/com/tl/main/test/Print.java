package com.tl.main.test;


/**
 * 将0-n*m-1 存入矩阵并顺时针打印 例如
 * 输入n=4 m=5
 * 打印
 * 0   1   2   3   4
 * 13  14  15  16  5
 * 12  19  18  17  6
 * 11  10  9   8   7
 */
public class Print {

    private static int num=0;

    private static int [] [] array;

    private static void init (int n,int m){

        int total=n*m;
        array =new int[n][m];
        int i=0,j=0;
        while(total>=0){
            //left --> right
            if(i==0&&j<m){
               j++;
               array[i][j]=num++;
            }

            //top -->bottom
            if(i<n&&j==m-1){
                i++;
                array[i][j]=num++;
            }

            //right -->left
            if(i==n-1&&j>0){
                j--;
                array[i][j]=num++;
            }

            //bottom -->top
            if(i<=n-1&&j==0){
                i--;
                array[i][j]=num++;
            }

            total--;
        }
    }

    public static void print(int array[][]){



    }

    public static void main(String[] args) {

    }

}
