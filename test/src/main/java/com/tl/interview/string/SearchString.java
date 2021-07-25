package com.tl.interview.string;


/**
 * 实现getStr()
 *      leetcode 28
 */
public class SearchString {

    /**
     * 朴素匹配方法  暴力解法，leetcode 超出时间限制
     * @param haystack super string
     * @param needle  sub string
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if(haystack.length()<needle.length())
            return -1;
        for (int i = 0; i <haystack.length() ; i++) {
            int j=i;
            int k=0;
            for (; k < needle.length() && j<haystack.length(); k++,j++) {
                if(haystack.charAt(j)!=needle.charAt(k)){
                    break;
                }
            }
            if(k==needle.length()){
                return i;
            }
        }
        return -1;
    }


    public int strStr2(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if(haystack.length()<needle.length())
            return -1;
        for (int i = 0; i <haystack.length()-needle.length(); i++) {
            int k=0;
            for (; k < needle.length(); k++) {
                if(haystack.charAt(k+i)!=needle.charAt(k)){
                    break;
                }
                if(k==needle.length()-1){
                    return i;
                }
            }

        }
        return -1;
    }
}
