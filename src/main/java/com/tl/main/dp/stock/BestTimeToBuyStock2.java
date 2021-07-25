package com.tl.main.dp.stock;


/**
 * 买股票的最佳时期 II
 *      leetcode 122
 *
 *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class BestTimeToBuyStock2 {

    /**
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //两种状态 1、当前持有股票 2、当前不持有股票

        int length=prices.length;

        //dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润, dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润
        int dp [] [] = new int [prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);//昨天持有股票加上今天的价格，与昨天不持有股票 取最大值
            dp[i][1]=Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);//昨天持有股票的价格，与昨天不持有股票然后今天持有股票 取最大值
        }
        return dp[length-1][0];
    }


    public int maxProfit2(int[] prices) { //优化
        //两种状态 1、当前持有股票 2、当前不持有股票
        int length=prices.length;

        //dp[0] 表示第 i 天交易完后手里没有股票的最大利润, dp[1] 表示第 i 天交易完后手里持有一支股票的最大利润
        int dp  [] = new int [2];
        dp[0]=0;
        dp[1]=-prices[0];
        for (int i = 1; i < length; i++) { //第 i 天交易完后的最大收益只与 第i-1天有关
            int newdp0=Math.max(dp[0], dp[1] + prices[i]);
            int newdp1=Math.max(dp[0] - prices[i], dp[1]);
            dp[0]=newdp0;
            dp[1]=newdp1;
        }
        return dp[0];
    }


    public int maxProfit3(int[] prices) { //贪心
       //交易不限次数， 只要股票涨了就都收割进来
        if(prices.length<2){
            return 0;
        }
        int res=0;

        int length= prices.length;
        int pre=prices[0];
        for (int i = 1; i < length; i++) {
            if(prices[i]>pre){
                res+= prices[1] -pre;
            }
            pre=prices[i];
        }
        return res;
    }
}
