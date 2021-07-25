package com.tl.main.dp;


import java.lang.reflect.Array;
import java.util.*;

/**
 * dp问题
 * 三角形的最短路径
 *              2
 *          3      4
 *      6      5       7
 * 4     1       8       9
 * 以上三角形由一连串的数字构成，要求从顶点 2 开始走到最底下边的最短路径，
 * 每次只能向当前节点下面的两个节点走，如 3 可以向 6 或 5 走，不能直接走到 7。
 */
public class Triangle {

    private static int[][] triangle = {
            {2},
            {3, 4},
            {6, 5, 7},
            {4, 1, 8, 3}
    };


    /**
     * 递归方式枚举所有的情况
     *              2
     *          3      4
     *      6      5       7
     * 4     1       8       9
     *  时间复杂度 O(2^n)
     * 重叠子问题
     *      显然traverse(2,1) traverse(3,1) traverse(3,2) 重复了 ，即内层三角形
     *
     *
     * @param i
     * @param j
     * @return
     */
    public static int traverse(int i, int j) {
        int totalRow = 4; // 总行数
        if (i >= totalRow - 1) {
            return 0;
        }
        // 往左下节点走时
        int leftSum = traverse(i + 1, j) + triangle[i + 1][j];
        // 往右下节点走时
        int rightSum = traverse(i + 1, j + 1) + triangle[i + 1][j + 1];
        // 记录每个节点往左和往右遍历的路径和的最小值
        return Math.min(leftSum, rightSum);
    }

    /**
     * 采用备忘录的方式来存子问题的解以避免大量的重复计算（剪枝）  将中间节点缓存起来
     *  时间复杂度 O(n) ,空间复杂度 O(n)
     * @param i
     * @param j
     * @return
     */
    private static Map<String,Integer> map=new HashMap<>();

    public static int traverse2(int i, int j) {
        String key=i+"_"+j;
        if(map.get(key)!=null)
            return map.get(key);
        int totalRow = 4; // 总行数
        if (i >= totalRow - 1) {
            return 0;
        }
        // 往左下节点走时
        int leftSum = traverse2(i + 1, j) + triangle[i + 1][j];
        // 往右下节点走时
        int rightSum = traverse2(i + 1, j + 1) + triangle[i + 1][j + 1];
        // 记录每个节点往左和往右遍历的路径和的最小值
        int res = Math.min(leftSum, rightSum);
        map.put(key,res);
        return res;
    }

    /**
     * dp 方式
     *              2
     *          3      4
     *      6      5       7
     * 4     1       8       9
     * @return
     */
    public static int traverse_dp(int [] [] array) {

        if(array.length==1)
            return array[0][0];
        int length= array.length;
        int [] dp = Arrays.copyOf(array[length-1],array[length-1].length);

        //从倒数第二层的数组开始计算最短路径
        for (int i = length-2; i >=0; i--) {
            for (int j = 0; j < array[i].length; j++) {
                dp[j]=Math.min(dp[j],dp[j+1])+ array[i][j];
            }
        }
        return dp[0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1)
            return triangle.get(0).get(0);
        int length= triangle.size();
        List<Integer> dp = triangle.get(triangle.size()-1);

        //从倒数第二层的数组开始计算最短路径
        for (int i = length-2; i >=0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp.set(j,Math.min(dp.get(j),dp.get(j+1))+triangle.get(i).get(j));
            }
        }
        return dp.get(0);
    }


    public static void main(String[] args) throws Throwable {
        int sum = traverse(0, 0) + triangle[0][0];
        System.out.println("sum = " + sum);

        int sum2 = traverse2(0, 0) + triangle[0][0];
        System.out.println("sum = " + sum2);

        System.out.println("sum = " +traverse_dp(triangle));
    }


}
