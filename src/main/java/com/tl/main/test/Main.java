package com.tl.main.test;

class A {
    String name;
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.name = "name1";
        String name = "name2";
        swap(a, name);
        System.out.println("a.name=" + a.name + ",name=" + name);



        char ch='8'; int r=10;

        switch( ch+1 )
        {
            case '7': r=r+3;
                System.out.println("3333");
            case '8': r=r+5;
                System.out.println("8888");
            case '9':
                System.out.println("99999");
                r=r+6;
                break;
            default: r=r+8;
                System.out.println("defalut");
        }

        System.out.println(r);

        int t=1;
        switch (6){
            case 1:
                System.out.println("1111");
            case 6:
                System.out.println("222222");
            case 7:
                System.out.println("3333");
                default:
                    System.out.println("default");
        }



    }

    public static void swap(A a, String name2) {
        String temp = a.name;
        System.out.println("temp:"+temp);
        a.name = name2;
        System.out.println("temp:"+temp);
        name2 = temp;
    }
}