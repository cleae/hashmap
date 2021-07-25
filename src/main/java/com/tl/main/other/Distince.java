package com.tl.main.other;

import java.util.Arrays;
import java.util.Comparator;

public class Distince {

    /**
     * 直接排序法
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] res = new int[R * C + 1][2];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[i * C + j] = new int[]{i, j};
            }
        }

        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0)) - (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0));
            }
        });


        return res;
    }

    /**
     * BFS遍历
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C + 1][2];

        return res;
    }

    /**
     * 桶排序
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder3(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C + 1][2];

        return res;
    }
}
