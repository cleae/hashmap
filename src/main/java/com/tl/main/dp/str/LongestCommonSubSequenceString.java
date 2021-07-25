package com.tl.main.dp.str;

public class LongestCommonSubSequenceString {
    /**
     * 最长公共子序列
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]表示text1的前i个字符与text2的前j个字符的最长公共子序列的个数
        int dp[][] =new int [text1.length()+1][text2.length()+1];
        for( int i=1; i<text1.length()+1 ; i++){
            for(int j=1; j<text2.length()+1; j++){
                if(text1.charAt(i-1)== text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
