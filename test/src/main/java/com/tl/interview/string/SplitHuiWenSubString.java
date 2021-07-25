package com.tl.interview.string;


import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文子串
 */
public class SplitHuiWenSubString {

    public List<List<String>> partition(String s) {
        List<List<String>> res =new ArrayList<List<String>>();
//        int split=1;
        int start=0;
        List<String> list = new ArrayList<String>();
        //start->length不断截取
        dfs(res,s,start, s.length(), list);
        return res;
    }

    public void dfs(List<List<String>> res,String s, int start,   int length , List<String> list){
        if(start==length){
            res.add(new ArrayList<String>(list));
            return ;
        }
        for(int i=start; i<length; i++) {
            //剪去不是回文串的情况
            if(!isHuiWen(s,start,i)){
                continue;
            }
            list.add(s.substring(start, i+1));
            dfs(res,s,i+1, length, list);
            list.remove(list.size()-1);
        }
    }
    //判断是否为回文串
    public boolean isHuiWen( String str, int left, int right){
        while(left<right){
            if(str.charAt(left)!= str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
