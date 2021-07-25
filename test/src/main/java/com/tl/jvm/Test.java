package com.tl.jvm;

/**
 * description: Test
 * created by lintan at 2020/12/8 17:01
 */
public class Test {

    public static void main(String[] args) {
        final int num=110;
        final int num2=111;
        String str="hello"+num+"world"+num2;

        System.out.println(mathexp(111111111111117L));
    }

    static public int mathexp (long n) {
        if(n<10)
            return (int)n;
        int res=1;

        while(n>=0){
            if(n==0){
                if(res<10)
                    break;
                else{
                    n=res;
                    res=1;
                    continue;
                }
            }
            int mod=(int)(n%10);
            System.out.print(mod+"\t");
            if(mod==0){
                return 0;
            }
            n=n/10;
            res=res*mod;
        }
        return res;
    }
}
