package com.tl.main.other;

import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 */
public class RemoveNumber {

    /**
     * 移除k位数字
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        if(num.length()==k)
            return "0";

        StringBuilder res=new StringBuilder();
        Stack<Character> answer =new Stack<>();
        answer.push(num.charAt(0));
        int index=1;
        while(k>0&&index<num.length()){
            Character character = answer.peek();
            int pre = character.charValue();
            //当前元素小于栈顶元素，弹出栈顶元素，否则当前元素不压栈继续到下一个元素
            if(num.charAt(index)<pre){
                answer.pop();
                k--;
            }
            else
                answer.push(num.charAt(index++));
            if(answer.empty())
                answer.push(num.charAt(index++));
        }
        while(index<num.length()){
            answer.push(num.charAt(index++));
        }
        while(k>0){
            answer.pop();
            k--;
        }
        while(!answer.empty())
            res.append(answer.pop());
        String string = res.reverse().toString();
        int i = 0;
        for (; i < string.length(); i++) {
            if(string.charAt(i)!='0')
                break;
        }
        String ress=string.substring(i);
        return ress.length()==0?"0":ress;

    }


    public static void main(String[] args) {

        System.out.println(removeKdigits("1340019"
                ,3));
    }
}
