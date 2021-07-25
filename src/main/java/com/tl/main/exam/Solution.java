package com.tl.main.exam;

import java.util.Arrays;

public class Solution {


    /**
     * 链接：https://ac.nowcoder.com/acm/contest/9715/B
     * 来源：牛客网
     * 给出一个仅包含小写字母的字符串s，你最多可以操作k次，使得任意一个小写字母变为与其相邻的小写字母（ASCII码差值的绝对值为1）
     * 请你求出可能的最长相等子序列（即求这个字符串修改至多k次后的的一个最长子序列，且需要保证这个子序列中每个字母相等）
     *
     * 子序列：从原字符串中取任意多个字母按照先后顺序构成的新的字符串。
     * @param k
     * @param s
     * @return
     */
    static public int string2 (int k, String s) {
        int ans=0,i,j;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for(i='a';i<'z';i++){//暴力解法，把最终转变成的字符 a-z 都试一遍
            for(j=0;j<chars.length;j++){
                int t=k,r;
                for(r=j;r<chars.length;r++){
                    t-=Math.abs(chars[r]-i);
                    if(t<0)break;
                    ans=Math.max(ans,r-j+1);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(string2(2,"abcde"));
    }
}
