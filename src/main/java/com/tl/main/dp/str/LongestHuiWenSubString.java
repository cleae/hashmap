package com.tl.main.dp.str;


/**
 * 最长回文子串
 *
 */
public class LongestHuiWenSubString {

    public String longestPalindrome(String s) {
        int n = s.length();
        //dp[i][j] 表示i...j是否是回文串
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {//长度等于1
                    dp[i][j] = true;
                } else if (l == 1) {//长度等于2
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {//长度大于2
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
        // int len=1;
        // int length=s.length();
        // String res="";
        // if(s.length()==0){
        //     return "";
        // }
        // res=res+s.charAt(0);
        // for( int i=0; i<length-1; i++){
        //     for(int j=i+1; j<=length; j++){
        //         String str=s.substring(i,j);
        //         if(isHuiWen(str,0,str.length()-1)){
        //             if(j-i>len){
        //                 len=j-i;
        //                 res=str;
        //             }
        //         }
        //     }
        // }
        // return res;
    }

    // public boolean isHuiWen(String str, int left, int right){
    //     while(left<right){
    //         if(str.charAt(left)!=str.charAt(right)){
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }
    //     return true;
    // }
}
