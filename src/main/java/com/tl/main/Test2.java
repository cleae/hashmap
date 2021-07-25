package com.tl.main;

import java.util.ArrayList;

public class Test2 {
    {
        System.out.println("Test 2 得构造代码块");
    }
    static {
        System.out.println("静态代码块。。");
    }
    /**
     * 静态代码块。。
     * Test 1 构造方法
     * Test 2 得构造代码块
     * Test 2 构造方法
     * Test 1 构造方法
     * print...
     *
     *静态代码块。。
     * Test 2 得构造代码块
     * Test 2 构造方法
     * Test 1 构造方法
     * Test 1 构造方法
     * print...
     *
     */
    private static Test2 test2=new Test2();
    private  static Test1 test1=new Test1();

    public  Test2(){
        System.out.println("Test 2 构造方法");
    }

    public static void main(String[] args) {
        new Test1().print();

        System.out.println(Test2.class.getClassLoader());


        System.out.println((int)'A' +"\t" +(int) 'B');

        System.out.println((int)'a' +"\t" +(int) 'b');
//        new ArrayList<StringTest>().t
    }
}

class  Test1 {

    public Test1(){
        System.out.println("Test 1 构造方法");
    }

    public void print(){
        System.out.println("print...");
    }
}
