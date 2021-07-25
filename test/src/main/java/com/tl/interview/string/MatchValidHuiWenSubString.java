package com.tl.interview.string;


import java.util.HashMap;
import java.util.Map;

/**
 * 验证回文子串
 *  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class MatchValidHuiWenSubString {


    /**
     * 空间复杂度 O(26) ==O(1)
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if("".equals(s))
            return true;
        Map<Character,Integer> map = new HashMap<>(32,1);
        for (int i = 0; i < 26; i++) {//a-z
            map.put((char)(i+97),0);
        }
        for (int i = 48; i < 58; i++) {//0-9
            map.put((char) i,0);
        }
        String str=s.toLowerCase();
        int left=0;
        int right=s.length()-1;

        while(left<right){
            if(map.get(str.charAt(left))==null){
                left++;
                continue;
            }else if(map.get(str.charAt(right))==null){
                right--;
                continue;
            }else{
                if(str.charAt(left)!=str.charAt(right)){
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((int)'b');

        System.out.println((int)'A');
        System.out.println((int)'B');

        System.out.println((int)';');
        System.out.println((int)',');
        System.out.println((int)':');
        System.out.println((int)'?');

        System.out.println("fgfdGFDFG;g[dfg".toLowerCase());
        System.out.println((int)' ');

        System.out.println(new MatchValidHuiWenSubString().isPalindrome("0f"));
        System.out.println((int)'0');
        System.out.println((int)'1');
        System.out.println((int)'2');
        System.out.println((int)'3');
        System.out.println((int)'4');
        System.out.println((int)'5');
        System.out.println((int)'6');
        System.out.println((int)'7');
        System.out.println((int)'8');
        System.out.println((int)'9');

//        "".substring()
        System.out.println(Math.abs(1-6));
    }
}
