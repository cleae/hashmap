package com.tl.dp;

import java.util.regex.Pattern;

/**
 * description: Solution
 * created by lintan at 2020/10/14 15:38
 */
public class Solution {

    /**
     *
     * @param n
     * @return
     */
       public static  int countWays(int n) {
            int coins[] = {1,2,5,10};
            int dp[] = new int[n+1];
            dp[0] = 1;
            for(int i = 0;i < 4;++i){
                for(int j = coins[i];j <= n;++j){
                    dp[j] =dp[j]+dp[j-coins[i]];
                }
            }
            return dp[n];
        }


    public static  boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int i=0;
        String sb="";
        String tb="";
        for(; i<s.length ;i ++){
            if(s[i]=='#' ){
                if (sb.length()>0){
                    sb=sb.substring(0,sb.length()-1);
                }
            } else
                sb+=s[i];
        }
        for (int j = 0; j < t.length; j++) {
            if(t[j]=='#' ){
                if (tb.length()>0){
                    tb=tb.substring(0,tb.length()-1);
                }
            } else
                tb+=t[j];
        }
        return sb.equals(tb);
    }


    /**
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     *
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * @param s
     * @return
     */
    public static String decodeString(String s) {

        System.out.println(s.indexOf('['));

        return s;
    }

  /*  public static String dfs(String str, int repeat){
        boolean matches = Pattern.matches("[0-9]\\[[a-z]+\\]", str);
        if(matches){
            dfs()
        }
        return str;
    }*/


    public static void main(String[] args) {

        System.out.println(countWays(5));


        System.out.println(backspaceCompare("ab#c#","abc##"));

        decodeString("2[abc]3[cd]ef");


        System.out.println(Pattern.matches("[0-9]\\[[a-z]+\\]", "2[abc]"));
    }

}
