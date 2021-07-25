package com.tl.main.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * description: Rope
 * created by lintan at 2020/11/4 9:54
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 示例2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36
 * 提示：
 *
 * 2 <= n <= 58
 *
 * 参考解题：
 *      https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/shu-xue-zhi-shi-he-dong-tai-gui-hua-liang-chong-fa/
 */
public class Rope {

    /**
     * 能被3整除，每次都剪掉3
     * 模3得1，先剪长度为4， 再每次都剪掉3
     * 模3得2，先剪长度为2， 再每次都剪掉3
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if(n<=3)
            return n-1;

        if(n%3==0){
            return (int)Math.pow(3,n/3);
        }else if(n%3==1){
            return 4* (int)Math.pow(3,(n-4)/3);
        }else{
            return 2* (int)Math.pow(3,n/3);
        }
    }

    /**
     * dp 方式
     * @param n
     * @return
     */
    static public int cuttingRope_dp(int n) { //2 <= n <= 58
        if(n<=3)
            return n-1;
        //长度为i的绳子能得到的最大的乘积
        int dp[] =new int[n+1];

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i]=Math.max(dp[i], Math.max(j,dp[j])*Math.max(i-j,dp[i-j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope_dp(2));
    }
}
