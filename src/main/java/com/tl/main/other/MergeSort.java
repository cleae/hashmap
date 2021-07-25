package com.tl.main.other;

public class MergeSort {
    int[] tmp;

    public int[] sortArray(int[] nums) {
        //快排
        // quickSort(nums, 0, nums.length-1);

        //堆排序
        // heapSort(nums);

        //归并
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    //堆排序
    public void heapSort(int nums []){
        //大顶堆初始化
        int length =nums.length;
        for(int i= length/2; i>=0; i--){
            heapAdjust(nums, i, length-1);
        }

        //交换后再次构造大顶堆
        for( int i=length-1; i>=0 ; i--){
            swap(nums, 0, i);
            heapAdjust(nums, 0, i-1);
        }
    }

    //构造大顶堆
    public void heapAdjust( int nums[] ,int index,int length){
        int temp= nums[index];//减少不必要的swap

        for( int i= index*2 ; i<=length; i*=2){
            if(i<length && nums[i]<nums[i+1]){
                i++;
            }
            if(temp >= nums[i]){
                break;
            }
            nums[index]= nums[i];
            index=i;
        }
        nums[index]= temp;
    }


    //归并排序
    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        merge(nums,l, mid, r);
    }

    public void merge( int nums [] ,int l ,int mid, int r){
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
//        Arrays.as
    }



    public void quickSort( int []nums, int left, int right){
        int pkey;

        while(left < right){
            pkey = partition(nums, left, right);
            quickSort(nums, left, pkey);
            left =pkey+1;
        }
    }

    public void swap(int nums[], int a, int b){
        int temp = nums[a];
        nums[a] =nums[b];
        nums[b]= temp;
    }

    public int partition( int nums [] , int left , int right){
        int pkey;

        //升序， 三数取中，保证nums[left] 是三数中最小的那个
        int mid = left + (right-left)/2;
        if(nums[left] > nums[mid]){
            swap(nums, left, mid);
        }
        if(nums[mid] >nums[right]){
            swap(nums, mid, right);
        }
        if(nums[left] > nums[right]){
            swap(nums, left, right);
        }

        pkey=nums[left];
        int temp =pkey;
        while( left < right){

            while(left <right && nums[right] >=pkey){
                right--;
            }
            nums[left]=nums[right];
            while(left<right && nums[left] <= pkey){
                left++;
            }
            nums[right] =nums[left];
        }
        nums[left]=temp;
        return left;
    }


    public static void main(String[] args) {
        int nums[] ={7,8,8,1,2,9,0};
        new MergeSort().sortArray(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }

//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE +12);
    }
}
