package com.tl.interview.dp;


import java.util.List;

/**
 * 单词拆分
 *      leetcode 139
 *
 */
public class SplitWord {


    /**
     * dp[i] 表示字符串s前i个字符能不能组成字典里的单词
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] dp =new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j <i ; j++) {
                //dp[j]从0开始，下一次进入if是dp[i]==true
                if(dp[j] &&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
