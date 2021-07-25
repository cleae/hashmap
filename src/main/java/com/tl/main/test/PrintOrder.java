package com.tl.main.test;


/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */
public class PrintOrder {


    public static int[] spiralOrder(int[][] matrix) {//螺旋矩阵
        int n = matrix.length;
        if (n == 0)
            return new int[0];

        int m = matrix[0].length;
        int total = n * m;
        int[] result = new int[total];

        int index = 0;
        //一直右转
        int operation = 0;
        //operation mod 4==0 j++
        int i = 0, j = -1;
        boolean[][] flags = new boolean[n][m];

        while (index < total) {

            if (operation == 0) {
                j++;
                if (j == m || flags[i][j]) {
                    j--;
                    operation = (operation + 1) % 4;
                    continue;
                }
            } else if (operation == 1) {
                i++;
                if (i == n || flags[i][j]) {
                    i--;
                    operation = (operation + 1) % 4;
                    continue;
                }

            } else if (operation == 2) {
                j--;
                if (j < 0 || flags[i][j]) {
                    j++;
                    operation = (operation + 1) % 4;
                    continue;
                }

            } else { //operation==3
                i--;
                if (i < 0 || flags[i][j]) {
                    i++;
                    operation = (operation + 1) % 4;
                    continue;
                }
            }
            result[index] = matrix[i][j];
//            System.out.printf("%d  ",matrix[i][j]);
            flags[i][j] = true;
            index++;
        }
        return result;
    }

    public int[][] generateMatrix(int n) {//螺旋矩阵2 构造螺旋矩阵

        int total = n * n;
        int index = 1;

        int res[][] = new int[n][n];
        int operation = 0;
        int i = 0;
        int j = -1;
        boolean access[][] = new boolean[n][n];
        while (index <= total) {
            if (operation == 0) {
                j++;
                if (j == n || access[i][j]) {
                    j--;
                    operation = (operation + 1) % 4;
                    continue;
                }
            } else if (operation == 1) {
                i++;
                if (i == n || access[i][j]) {
                    i--;
                    operation = (operation + 1) % 4;
                    continue;
                }
            } else if (operation == 2) {
                j--;
                if (j < 0 || access[i][j]) {
                    j++;
                    operation = (operation + 1) % 4;
                    continue;
                }
            } else {
                i--;
                if (i < 0 || access[i][j]) {
                    i++;
                    operation = (operation + 1) % 4;
                    continue;
                }
            }
            res[i][j] = index;
            access[i][j] = true;
            index++;
        }
        return res;
    }

    /**
     * * 0   1   2   3   4
     * * 13  14  15  16  5
     * * 12  19  18  17  6
     * * 11  10  9   8   7
     *
     * @param args
     */
    public static void main(String[] args) {

        int[][] array = {new int[]{0, 1, 2, 3, 4}, new int[]{13, 14, 15, 16, 5}, new int[]{12, 19, 18, 17, 6}
                , new int[]{11, 10, 9, 8, 7}};


//        int [] [] array={};
        int[] ints = spiralOrder(array);

        System.out.println();
        for (int i : ints) {
            System.out.printf("%d  ", i);
        }


    }
}
