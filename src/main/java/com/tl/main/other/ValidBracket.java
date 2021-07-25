package com.tl.main.other;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效的括号
 */
public class ValidBracket {

    public boolean isValid(String s) {

        int length =s.length();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Deque<Character> stack = new LinkedList<>();

        for( int i=0 ;i <length; i++){
            char ch =s.charAt(i);
            if(map.containsKey(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty() || ch != map.get(stack.pop())){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(2<<31 -1);
        System.out.println((long)1<<32 -1);
        System.out.println(Math.sqrt(10));
    }
}
