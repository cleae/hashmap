package com.tl.main.dp.stock;


/**
 * 买股票的最佳时期 I
 *      leetcode 121
 */
public class BestTimeToBuyStock {

    /**
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * @param prices
     * @return
     */
    public int res(int[] prices) {//暴力
        int res=0;
        for( int i=0 ; i<prices.length; i++){
            for (int j = i+1; j < prices.length; j++) {
                if(prices[i]<prices[j]){
                    res=Math.max(res,prices[j]-prices[i]);
                }
            }
        }
        return res;
    }


    public int res2(int[] prices) { //动态规划
        int length = prices.length;
        if(length<2){
            return 0;
        }
        //dp[i] 表示前i天的股票最大利润
        int  dp [] =new int [length];
        dp[0]=0;
        int min=prices[0];
        for (int i =1; i < length; i++) {
            min=Math.min(min,prices[i]);
            dp[i]= Math.max(dp[i-1], prices[i]- min);
        }
        return dp[length-1];
    }


    public int res3(int[] prices) { //一次遍历
        int minprice = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            }
            res=Math.max(res,prices[i] - minprice);
        }
        return res;
    }
}
