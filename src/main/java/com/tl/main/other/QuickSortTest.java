package com.tl.main.other;

import java.util.Arrays;

public class QuickSortTest {
    static public int findKth(int[] a, int n, int K) {
        // write code here
//        Arrays
        quickSort(a,0,n-1);
        return a[n-K];
    }

    static public void quickSort( int a [], int left, int right){
        int pkey;
        while(left< right){
            pkey= parition(a, left,right);
            quickSort(a, left, pkey);
            left=pkey+1;
        }
    }

    static public int  parition( int a [] , int left, int right){
        int pkey;
        int mid= left+ (right-left)/2;

        if(a[mid] > a[right]){
            swap(a, mid, right);
        }
        if(a[left] > a[mid]){
            swap(a, mid, left);
        }
        if(a[left] > a[right]){
            swap(a, left, right);
        }
        pkey= a[ left];
        while(left< right){
            while( left<right && a[right] >=pkey){
                right--;
            }
            a[left]= a[right];
            while(left<right && a[left]<= pkey){
                left++;
            }
            a[right]=a[left];
        }
        a[left]=pkey;
        return left;
    }

    static public void swap( int a[] , int left, int right){
        int temp= a[left];
        a[left] =a[right];
        a[right]=temp;
    }


    public static void main(String[] args) {
        int arr[] ={1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        int len=49;
        int k=24;
        findKth(arr, len, k);


        System.out.println(0>>>1);
    }
}
