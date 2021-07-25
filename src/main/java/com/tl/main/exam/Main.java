package com.tl.main.exam;

import java.util.HashSet;

public class Main {
    /*private static int time=0;
    public void perm (char[] str, int start, int end, HashSet <StringTest> set){
        time++;
        if(start==end){
            StringBuilder b = new StringBuilder();
            for (int i = 0; i<str.length; i++) {
                b.append(str[i]);
            }
            System.out.println(b.toString());
            set.add(b.toString());
        }
        else{
//            Arrays.
//            Arrays.
            for (int i = start; i < end; i++) {
                swap(str,start,i);
                perm(str,start+1,end,set);
                swap(str,start,i);

            }
        }

    }
    public void swap(char[] chars, int i,int j){
        char temp=chars[j];
        chars[j]=chars[i];
        chars[i]=temp;
    }

    public StringTest[] permutation(StringTest s) {
        if("".equals(s) || s==null)
            return new StringTest[0];
        char [] array=s.toCharArray();
        HashSet<StringTest> set =new HashSet<StringTest> ();
        perm(array, 0, array.length, set);
        StringTest[] result =new StringTest[set.size()];

        return set.toArray(result);
    }


    public static void main(StringTest[] args) {
        StringTest[] permutation = new Main().permutation("123");

        for (StringTest str : permutation){


            System.out.println(str);
        }
    }
*/
}
