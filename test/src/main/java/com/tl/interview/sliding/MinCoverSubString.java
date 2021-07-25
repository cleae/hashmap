package com.tl.interview.sliding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * description: MinCoverSubString
 * created by lintan at 2020/12/11 16:38    最小覆盖子串
 */
public class MinCoverSubString {


    Map<Character, Integer> sub = new HashMap<Character, Integer>();
    Map<Character, Integer> sup = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();

        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            sub.put(c, sub.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && sub.containsKey(s.charAt(r))) {//包含的k就put,不包含的就不要put,节省空间
                sup.put(s.charAt(r), sup.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                //取最小值
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (sub.containsKey(s.charAt(l))) {//l 尝试往右收缩
                    sup.put(s.charAt(l), sup.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = sub.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (sup.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
    public static int solve (int a, int b) {

        int res=b;

        while(res<a){
            res<<=1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solve(12,2));
    }

}
