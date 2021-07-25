package com.tl.other;

import org.omg.CORBA.ARG_IN;

/**
 * description: Number
 * created by lintan at 2020/11/5 19:07
 *
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用补码运算方法。
 *
 * 注意:
 *
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 *
 * 示例 1：
 * 输入:
 * 26
 * 输出:
 * "1a"
 *
 * 示例 2：
 * 输入:
 * -1
 * 输出:
 * "ffffffff"
 */
public class Number {

    /**
     * 十进制转十六进制
     * @param num
     * @return
     */
    public static String toHex(int num) {

        if (num == 0)
            return "0";
        char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder sb = new StringBuilder();

        while (sb.length() < 8 && num != 0) {
            sb.append(chars[num & 0xf]);
            num >>= 4;
        }
        return sb.reverse().toString();

    }

    /**
     * 给你一个整数数组arr。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
     * 如果存在多个数字二进制中1的数目相同，则必须将它们按照数值大小升序排列
     * @param arr
     * @return
     */
    public static int[] sortByBits(int[] arr) {
        if(arr.length<2)
            return arr;
        //比较大小 直接插入法
        for (int i = 1; i < arr.length; i++) {
            int j,temp;
            if(get(arr[i])<get(arr[i-1]) ||(get(arr[i])==get(arr[i-1]) &&arr[i]<arr[i-1])){
                temp=arr[i];
                System.out.println("i:"+i);
                for ( j= i-1; j>=0&&(get(arr[j])>get(temp)||(get(temp)==get(arr[j]) &&temp<arr[j])); j--) {
                    arr[j+1]=arr[j];
                }
                arr[j+1]=temp;
            }
        }
        return arr;
    }

    static int get(int num){

        int res=0;
        while(num>0){
            res+=num&1;
            num>>=1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(2>>1);
        System.out.println(-2>>>1);
        System.out.println(-2147483647>>>1);

        System.out.println(toHex(2));
        System.out.println(toHex(1024));
        System.out.println(toHex(1024<<10));
        System.out.println(toHex(5455596));


        int [] arr={1024,512,256,128,64,32,16,8,4,2,1};


        int[] ints = sortByBits(arr);
        for(int i:ints)
            System.out.println(i);

        System.out.println("-------");
        System.out.println(7^ Integer.MAX_VALUE);
        System.out.println(8^ Integer.MAX_VALUE);


        System.out.println(get(377));
        System.out.println(get(624));
    }
}
