package com.tl.main.dp;


/**
 * 已知有1元 2元 5元 10元 四种钱币  给定金额n 元，问总共有多少兑换方法
 *
 * sum :金额
 * x1 x1 ...xn :
 */
public class Amount2 {
    /**
     * @param x 商品金额
     */
    public static void test2(int n){
        //纸币面额
        int money[]={1,2,5,10};
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i = 0;i < 4;++i){
            for(int j = money[i];j <= n;++j){
                dp[j] =(dp[j]+dp[j-money[i]]);
            }
        }
        System.out.println(dp[n]);
    }




    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        test2(3);
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间：" + (endTime - startTime) + "ms");
    }

}
