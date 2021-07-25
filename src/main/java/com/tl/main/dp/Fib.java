package com.tl.main.dp;


import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列
 * dp 入门
 * 动态规划的三要素
 *      最优子结构 （子问题的最优解）
 *      状态转移方程
 *      重叠子问题
 *
 *      定义子问题的状态与写出状态转移方程是解决动态规划最为关键的步骤
 * dp 问题特征：求最值，最优解，有重叠子问题
 *
 * 斐波那契数列
 *      0、1、1、2、3、5、8、13、21、34、……
 *      F(0)=0，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*）
 *
 */
public class Fib {

    /**
     *  回溯方式
     *  递归树
     *                f(6)              1
     *             /     \
     *        f(5)        f(4)          2
     *        /  \        /  \
     *      f(4)  f(3)  f(3)  f(2)      4
     *
     *     时间复杂度为O(2^n)
     *
     *
     * @param n
     * @return
     */
    public static int fib(int n){
        if(n<=2)
            return n;
        return fib(n-1) + fib(n-2);

    }

    /**
     * 回溯方式，基于上一种方式进行剪枝
     * 采用备忘录的方式来存子问题的解以避免大量的重复计算（剪枝）  将中间节点缓存起来
     *
     *  进行剪枝过后的递归树
     *                    f(6)
     *                   /
     *              f(5)        f(4)
     *             /          /  \
     *           f(4)  f(3)  f(3)  f(2)
     *          /
     *        f(3)  f(2)
     *        /  \
     *      f(2) f(1)
     *      由于用map 缓存了f(n)的值，因此不用再计算重叠的子问题
     *      时间复杂度由原来的O(2^n) 变为现在的 O（n） ,空间复杂度为O(n)
     * @param n
     * @param map 用于存储fib(n)
     * @return
     */
    public static int fib(int n, Map<Integer,Integer> map){
       if(n<=2)
            return  n;
       if(map.get(n)!=null)
           return map.get(n);

       int res =fib(n-1,map) + fib(n-2,map);
       map.put(n,res);
       return res;
    }
    /**
     * dp方式
     * 时间复杂度 O(n) ,空间复杂度 O(n)
     *
     * 通过简单地斐波那契的例子，相信大家对自底向上，DP 状态， DP 转移方程应该有了比较深入地认识，
     * 细心的同学一定发现了最优子结构怎么没有，因为前面我们也说了，斐波那契数列并不是严格意义上的动态规划
     * @param n
     * @return
     */
    public static int fib_dp( int n) {
        int []dp= new int [n+1];

        //初始状态
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n; i++) {
            //状态转移方程
            dp[i]=dp[i-1] + dp [i-2];
        }
        return dp[n];
    }

    /**
     * 优化空间复杂度
     * @param n
     * @return
     */
    public static int fib_dp2( int n) {

        //初始状态
        int res=0;
        int pre=1,next=2;
        for (int i = 3; i <=n; i++) {
            //状态转移方程
            res=pre+next;
            pre=next;
            next=res;
        }
        return res;
    }

    public static void main(String[] args) {


        System.out.println(fib(5));
        System.out.println(fib(5,new HashMap<Integer,Integer>()));
        System.out.println(fib_dp(5));
        System.out.println(fib_dp2(5));
    }
}
