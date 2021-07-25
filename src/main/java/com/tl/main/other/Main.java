package com.tl.main.other;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public int countHomogenous(String s) {
        int length= s.length();
        char arr [] = s.toCharArray();
        List<List<Character>> res = subsetsWithDup(arr);


        int ans=0;
        for(List<Character> list : res){
            if(check(list)){
                ans++;
            }
        }
        return ans-1;

    }
    public List<List<Character>> subsetsWithDup(char[] nums) {
        List<List<Character>> res = new ArrayList<>();
        int start =0;
        List<Character> item= new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, start ,nums , item);
        return res;
    }

    //回溯
    public void dfs( List<List<Character>> res , int start , char nums [] , List<Character> item){
        res.add(new ArrayList<Character>(item));

        for( int i=start ; i<nums.length; i++){
            if(i!=start && nums[i-1] ==nums[i]){
                continue;
            }
            item.add(nums[i]);
            dfs(res, i+1, nums , item);
            item.remove(item.size()-1);
        }
    }

    public boolean check(List<Character> res){

        int size =res.size();
        if(size<2)
            return true;
        char ch = res.get(0);
        for(Character ch2 : res){
            if(ch !=ch2){
                return false;
            }
        }
        return true;
    }

    static
    public int minOperations(String s) {
        int length = s.length();
        if(length <2)
            return 0;
        int a=0,b=1;
        int pre=s.charAt(0)-'0';
        for(int i=1 ;i<length ;i++){
            if(s.charAt(i) -'0' ==pre){
                a++;
                pre^=pre;
            }else{
                b++;
                pre=s.charAt(i)-'0';
            }
        }
        return Math.min(a,b);
    }

    public static void main(String[] args) {
        String str= "abbcccaa";
        System.out.println(new Main().countHomogenous(str));


//        String zero= "111101";
//        minOperations(zero);


        System.out.println(-10>>1);
        System.out.println(-10>>>1);
    }
}
