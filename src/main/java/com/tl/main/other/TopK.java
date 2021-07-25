package com.tl.main.other;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopK {

    static public int[] topKFrequent(int[] nums, int k) {
        // 统计每个数字出现的次数
        Map<Integer, Integer> counter = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        // 定义小根堆，根据数字频率自小到大排序
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> counter.get(v1) - counter.get(v2));
        // 遍历数组，维护一个大小为     k 的小根堆：
        // 不足 k 个直接将当前数字加入到堆中；否则判断堆中的最小次数是否小于当前数字的出现次数，若是，则删掉堆中出现次数最少的一个数字，将当前数字加入堆中。
        counter.forEach((num, cnt) -> {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (counter.get(pq.peek()) < cnt) {
                pq.poll();
                pq.offer(num);
            }
        });
        // 构造返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num: pq) {
            res[idx++] = num;
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k){
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer item = count.get(nums[i]);
            if(item!=null){
                count.put(nums[i], item+1);
            }else{
                count.put(nums[i],1);
            }
        }
        //构造小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> count.get(num1) - count.get(num2));

        for (Map.Entry<Integer,Integer> num : count.entrySet()){
            if(queue.size() <k){
                queue.offer(num.getKey());
            }else{
                if( num.getValue() > count.get(queue.peek())){
                    queue.poll();
                    queue.offer(num.getKey());
                }
            }
        }
        int res[] =new int[k];
        int idx = 0;
        for (int num: queue) {
            res[idx++] = num;
        }
        return res;
    }


    //top 基于快排
    public int[] topKFrequent3(int[] nums, int k){
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer item = count.get(nums[i]);
            if(item!=null){
                count.put(nums[i], item+1);
            }else{
                count.put(nums[i],1);
            }
        }

        Count [] counts = new Count[count.size()];
        int index=0;
        for( Map.Entry<Integer,Integer> entry : count.entrySet()){
            counts[index++] = new Count( entry.getKey(), entry.getValue());
        }
        quickSort(counts, 0, counts.length-1);

        int  res [] = new int[k];
        index=0;
        for(Count cou : counts){
            if(index ==k)
                break;
            res[index++]= cou.num;
        }
        return res;
    }

    class Count{
        int num;
        int frequent;

        public Count(int num, int frequent) {
            this.num = num;
            this.frequent = frequent;
        }
    }

    public void quickSort( Count nums[], int left ,int right){
        int pkey;
        while(left <right){
            pkey =partition(nums, left, right);
            quickSort(nums, left ,pkey);
            left=pkey+1;
        }
    }
    public void swap(Count num1 , Count num2){
        int num = num1.num;
        int frequent = num1.frequent;
        num1.num= num2.num;
        num1.frequent=num2.frequent;
        num2.frequent=frequent;
        num2.num=num;
    }

    public int  partition ( Count nums[] , int left, int right){

        Count pkey;
        //三数取中
        int mid = left + (right-left) /2;
        if(nums[mid].frequent< nums[right].frequent){
            swap(nums[mid] , nums[right]);
        }
        if(nums [mid].frequent >nums[left].frequent){
            swap(nums[mid] , nums[left]);
        }
        if(nums[left].frequent < nums[right].frequent){
            swap(nums[left] , nums[right]);
        }
        pkey =nums[left];

        Count temp = nums[left];
        while(left < right){
            while(left <right && nums[right].frequent <= pkey.frequent){
                right--;
            }
            nums[left]=nums[right];
            while(left <right && nums[left].frequent >= pkey.frequent){
                left++;
            }
            nums[right] =nums[left];

        }
        nums[left] = temp;
        return left;
    }



    public static void main(String[] args) {
        int nums [] = {1,1,1,2,2,3,7,7,7,9,9,9,9,9};
//        topKFrequent(nums,2);


        new TopK().topKFrequent3(nums,2);

    }
}
