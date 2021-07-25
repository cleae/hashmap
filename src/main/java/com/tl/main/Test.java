package com.tl.main;

public class Test {

    {
        System.out.println("构造代码块");
    }

    static{
        System.out.println("静态代码块");
    }


    public  Test(){
        System.out.println("构造函数");
    }


    public  static int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static boolean judgeCircle(String moves) {

        int x =0,y=0;
        for (int i = 0; i < moves.length(); i++) {
            char dir=moves.charAt(i);
            switch (dir){
                case 'U':
                    y++;
                    break;
                case 'D' :
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R' :
                    x++;
                    break;
            }
        }

        if(x==0&&y==0)
            return true;
        System.out.println(x+"\t"+y);
        return false;
    }




    public static void main(String[] args) {
        new Test();

        System.out.println(fib(10));

        System.out.println(judgeCircle("RLUURDDDLU"));
    }
}
