package com.tl.main.test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void dfs(List<List<Integer>> res,int grid [][], int total, int i, int j ,List<Integer> item,boolean access[] []){
        int row=grid.length;
        int clu=grid[0].length;
        if(total ==row *clu){
            res.add(new ArrayList<>(item));
            return;
        }
        if(i>=row || j>=clu || i<0 || j<0 || access[i][j]){
            return ;
        }
        item.add(grid[i][j]);
        access[i][j]=true;
        total++;
        dfs(res, grid,total,i+1,j,item,access);
        dfs(res, grid,total,i,j+1,item,access);
        dfs(res, grid,total,i-1,j,item,access);
        dfs(res, grid,total,i,j-1,item,access);

    }

    public List<List<Integer>> path(int [] [] grid){
        int m=grid.length;
        int n=grid[0].length;
        //
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> item =new ArrayList<>();

        return null;
    }


    /**
     * 兑换钻石
     * @param x 金币
     * @param y 银币
     * @param z 铜币
     *          x:y:z=1:1:1 兑换一个钻石
     *          金币可以分解成两个银币或者三个铜币
     *          三个银币+四个铜币可以兑换一个金币
     * @return
     */
    static public int change(int x, int y ,int z){
        int res=0;

        //有则兑换
        int min=Math.min(x,y);
        min=Math.min(min,z);
        res+=min;

        x-=min;
        y-=min;
        z-=min;
        //金币少，合成金币
        if(x==0){
            while(y-3>=x+1 && z-4>=x+1){
                x++;
                y-=3;
                z-=4;
            }
        }
        //银币少 铜币少
        else if(y==0 || z==0){
            while(x-1 >= Math.min(x,y)){
                x--;
                y+=2;
                z+=3;
            }
        }
        min=Math.min(x,y);
        min=Math.min(min,z);
        res+=min;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(change(6,19,46));
        System.out.println(change(6,2,2));
        System.out.println(change(6,2,0));
        System.out.println(change(12,0,0));
        System.out.println(change(0,12,13));
        System.out.println(change(0,0,0));
    }
}
