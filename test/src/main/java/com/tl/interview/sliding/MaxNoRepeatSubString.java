package com.tl.interview.sliding;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * description: MaxNoRepeatSubString
 * created by lintan at 2020/12/11 17:09
 */
public class MaxNoRepeatSubString {


    /**
     * 无重复字符的最长子串 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int left=0;
        int right=0;
        int res=0;
        for( int i=right; i<s.length(); i++){
            if(map.get(s.charAt(i))!=null){
               left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            res=Math.max(res,i-left+1);
        }
        return res;
    }


    public static void main(String[] args) {
        new ArrayList<Integer>();//jhfgjhyrsty
    }
}
