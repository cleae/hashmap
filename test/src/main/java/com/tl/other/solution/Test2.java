package com.tl.other.solution;

public class Test2 {
    private static int num;
    static {
        num+=3;
        System.out.println(1);
    }
    static
    {
        num-=4;
        System.out.println(3);
    }
    static
    {
        num-=4;
        System.out.println(2);
    }

    public static void main(String[] args)
    {
        System.out.println(Test2.num);
    }
}
