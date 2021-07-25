package com.tl.main.dp;


import java.util.*;

/**
 * 凑零钱
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3  解释: 11 = 5 + 5 + 1
 * 输入: coins = [2], amount = 3，
 * 输出: -1
 */
public class Amount {


    /**
     * 递归方式
     *      结束条件 当前硬币加上原来的金额大于总金额 或者正好等于总金额
     *      执行过程 遍历硬币，金额从大到小
     *      返回结果 叠加的次数
     * @param coins
     * @param amount
     * @return
     */
    public static  int coinChange(int[] coins, int amount) {
        // 说明零钱刚好凑完
        if (amount == 0) {
            return 0;
        }
        // 说明没有满足的条件
        if (amount < 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subMin = coinChange( coins,amount - coins[i]);
            if (subMin == -1) continue;
            result = Math.min(subMin + 1, result);
        }
        // 说明没有符合问题的解
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    // 保存中间结果
    private static HashMap<Integer, Integer> map = new HashMap();


    /**
     * 剪枝
     * @param coins
     * @param amount
     * @return
     */
    public static  int coinChange2(int[] coins, int amount) {
        if (map.get(amount) != null) {
            return map.get(amount);
        }
        // 说明零钱刚好凑完
        if (amount == 0) {
            return 0;
        }
        // 说明没有满足的条件
        if (amount < 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subMin = coinChange2( coins,amount - coins[i]);
            if (subMin == -1) continue;
            result = Math.min(subMin + 1, result);
        }
        // 说明没有符合问题的解
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        map.put(amount, result);
        return result;
    }


    /**
     * dp 方式
     * @param coins
     * @param amount
     * @return
     */
    public static  int coinChange_dp(int[] coins, int amount) {

        //使用dp[i] 表示凑够零钱i所需要的最小值
        int dp [] =new int[amount+1];
        //状态转移方程
        /**
         * dp[i] = min {dp[i -coins[1]] ，dp[i -coins[2]] ，...,dp[i -coins[length-1]] }+1
         */
        // 初始化每个值为 amount+1，这样当最终求得的 dp[amount] 为 amount+1 时，说明问题无解
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }
        // 0 硬币本来就没有，所以设置成 0
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i- coins[j]] + 1, dp[i]);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }


    public int coinChange22(int[] coins, int amount) {
        int max = amount + 1;
        //使用dp[i] 表示凑够零钱i所需要的最小值
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                /**
                 * 假如coins= {1,2,5} ,要计算dp[6] ,把dp[6-1] dp[6-2] dp[6-5] 都比较一下取最小值
                 */
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static  void main(String[] args)  throws Throwable {
        int amount = 6;
        int[] coins = {1,2,5};
        int result = coinChange( coins,amount);
        System.out.println("result = " + result);
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.contains()

        int amount2 = 3;
        int[] coins2 = {2};
        int result2 = coinChange2( coins2,amount2);
        System.out.println("result = " + result2);

//        new ArrayList<Integer>().to
//        Deque<Integer> integers = new LinkedList<>();
//        integers.toArray(new Integer[integers.size()-1]);
//        StringBuilder res=new StringBuilder();
//        res.append

        int tt='9'-'0';
        System.out.println(tt);
    }

}
