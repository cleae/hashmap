package com.tl.main.dp.knapsack;

import javax.swing.plaf.IconUIResource;

/**
 * description: Knapsack
 * created by lintan at 2020/11/10 16:23
 */
public class Knapsack {

    /**
     * 0,1背包问题
     * @param w 物品重量数组
     * @param v 物品价值数组
     * @param N 物品的个数
     * @param W 背包的总容量
     * @return
     */
    static int _01knapsack(int[] w, int[] v, int N, int W){

        //状态转移方程 dp[n][w] 当背包且能容纳 w 的重量时，放入前 n 件物品（不一定全部都放入）的最大价值
        int dp [] [] =new int[N+1][W+1];

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j <W+1 ; j++) {
                if(w[i]>j){//背包容量小于第i件物品的重量，取放入第i-1个物品且能容纳j重量时的最大价值
                    dp[i][j]=dp[i-1][j];
                }
                else {//背包容量j大于当前物品重量w[i]
                    //决策放入还是不放入，取最大值
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }
        return dp[N][W];
    }

    //0 1背包优化
    static int _01knapsack_2(int[] w, int[] v, int N, int W){
        return -1;
    }


    /**
     * #include<bits/stdc++.h>
     *
     * using namespace std;
     *
     * const int maxsize=1001;
     * int w[maxsize];//重量或者体积
     * int v[maxsize];//价值
     * int dp[maxsize][maxsize];
     * int main()
     * {
     *     int n,m;
     *     cin>>n>>m;
     *     for(int i=1; i<n+1;i++){
     *         cin>>w[i]>>v[i];
     *     }
     *     for(int i=1; i<n+1; i++){
     *         for(int j=1; j<m+1; j++){
     *             if(j<w[i]){
     *                 dp[i][j]=dp[i-1][j];
     *             }else{
     *                 dp[i][j]=max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
     *             }
     *         }
     *     }
     *     cout<<dp[n][m];
     *     return 0;
     * }
     * @param args
     */


    /**
     * 完全背包问题，每个物品可以放任意次
     * @param w 物品重量数组
     * @param v 物品价值数组
     * @param N 物品的个数
     * @param W 背包的总容量
     * @return
     */
    static int _knapsack(int[] w, int[] v, int N, int W){




        return -1;
    }
    public static void main(String[] args) {
        int N = 3, W = 5; // 物品的总数，背包能容纳的总重量
        int [] w = {0, 3, 2, 1}; // 物品的重量
        int [] v = {0, 5, 2, 3}; // 物品的价值
        int total = _01knapsack(w, v, N, W);
        System.out.println("能放入背包的最大价值为:"+ total);
    }
}
