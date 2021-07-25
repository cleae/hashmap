package com.tl.other;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 17
 */
public class PhoneNumber {

    public List<String> letterres(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(res, phoneMap, digits, 0, new StringBuffer());
        return res;
    }


    /**
     *
     * @param res
     * @param phoneMap
     * @param digits 号码
     * @param index 号码下标
     * @param item
     */
    public void backtrack(List<String> res, Map<Character, String> phoneMap, String digits, int index, StringBuffer item) {
        if (index == digits.length()) {
            res.add(item.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();

            for (int i = 0; i < lettersCount; i++) {
                item.append(letters.charAt(i));
                backtrack(res, phoneMap, digits, index + 1, item);
                item.deleteCharAt(index);
            }
        }
    }

}
