package com.tl.other.solution;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //算出所有子集，求和比较最大值
    public int MaxMilk (int[] grass, int[] milk) {
        int m=grass.length;
        int n=milk.length;
        ArrayList<Bull> bulls = new ArrayList<>();
        for(int i=0 ; i<m; i++){
            bulls.add(new Bull(grass[i] , milk[i]));
        }
        List<List<Bull>> res = new ArrayList<>();
        int size= bulls.size();
        res.add(new ArrayList<>(0));
        for(int i=0 ; i<size; i++){
            int all= res.size();
            for(int j=0 ; j<all ;j++){
                ArrayList<Bull> list = new ArrayList<>(res.get(j));
                list.add(bulls.get(i));
                res.add(list);
            }
        }

        int ans=Integer.MIN_VALUE;
        for(List<Bull> list: res){
            boolean flag = milk(list);
            if(flag){
                int sum=0;
                for(Bull bull : list){
                    sum+=bull.milk;
                }
                ans=Math.max(ans, sum);
            }
        }
        return ans;
    }

    class Bull{
        int grass;
        int milk;

        public Bull(int grass, int milk) {
            this.grass = grass;
            this.milk = milk;
        }
    }
    public boolean milk( List<Bull> bull){
        int m= bull.size();
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<m; j++){
                if(j==i){
                    continue;
                }
                if(bull.get(i).grass > bull.get(j).grass && bull.get(i).milk <bull.get(j).milk){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int [] grass={3,5,8,2};//[3,5,8,2],[2,3,5,7]
        int milk[] ={2,3,5,7};
        System.out.println(new Main().MaxMilk(grass, milk));
    }
}
