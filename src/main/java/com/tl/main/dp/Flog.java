package com.tl.main.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * description: Flog
 * created by lintan at 2020/11/3 9:26
 * 青蛙跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 *
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 * 提示：0 <= n <= 100
 */
public class Flog {

    /**
     * dp
     * f(i)= max(f(i-1),f(i-2))
     *
     * f(n ) = f(n-1) + f(n - 2)
     * 跳台阶最后一条要么是1 要么是2
     * @param n
     * @return
     */
    public int numWays(int n) {

        if(n<2)
            return 1;
        //dp[i]表示跳上一个i级台阶最多有多少种跳法
        int dp[] =new int[n+1];

        //初始条件
        dp[0]=1;
        dp[1]=1;
        //状态转移方程
        for (int i = 2; i <=n; i++) {
            dp[i]= (dp[i-2] +dp[i-1])% 1000000007;
        }
        return dp[n];
    }

    /**
     * 优化空间复杂度为 O(1)
     * @param n
     * @return
     */
    public int numWays2(int n) {
        if(n<2)
            return 1;
        int curr=1;
        int pre=1;
        //状态转移方程
        for (int i = 2; i <=n; i++) {
           int temp=(pre+curr)% 1000000007;
           pre=curr;
           curr=temp;
        }
        return curr;
    }

    /**
     * 使用递归+ 减枝
     * @param n
     * @return
     */
    static Map<Integer,Integer> map = new HashMap<>();
    public static int numWays_re(int n) {
        //结束条件
        if(n<2)
            return 1;
        if(map.get(n)!=null)
            return map.get(n);
        int x=numWays_re(n-1);
        map.put(n-1,x);
        int y=numWays_re(n-2);
        map.put(n-2,y);
        return (x+y)% 1000000007;
    }


}
