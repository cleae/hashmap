package com.tl.main.other;


import java.util.Arrays;

/**
 * 上升下降字符串
 *      leetcode 1370
 */
public class UPDownString {


    static public String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String str = Arrays.toString(chars);
        StringBuilder source=new StringBuilder(str);
        StringBuilder res=new StringBuilder();
        char pre='\0';
        while(source.length()>0){
            if(str.length()>0){
                pre=source.charAt(0);
                source.deleteCharAt(0);
                res.append(pre);
            }

            for (int i = 1; i < source.length(); i++) {
                if(pre>source.charAt(i)){
                    res.append(source.charAt(i));
                    pre=source.charAt(i);
                    source.deleteCharAt(i);
                }
            }

            if(source.length()>0){
                pre=source.charAt(source.length()-1);
                source.deleteCharAt(source.length()-1);
                res.append(pre);
            }

            for (int i = source.length()-1; i >=0; i--) {
                if(pre<source.charAt(i)){
                    res.append(source.charAt(i));
                    pre=source.charAt(i);
                    source.deleteCharAt(i);
                }
            }
        }

        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println("sort:"+sortString("leetcode"));
    }
}
