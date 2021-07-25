package com.tl.main.dp.str;

public class LongestCommonSubString {
    /**
     * 最长公共子子串/最长重复子数组
     * @return
     */
    public int findLength(int[] A, int[] B) {

        int res=0;
        int [][] dp = new int [A.length] [B.length];
        for( int i=0; i< A.length; i++){
            for( int j=0 ; j<B.length; j++){
                if(A[i]==B[j]){
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                }
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
