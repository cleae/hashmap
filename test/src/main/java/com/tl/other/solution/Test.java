package com.tl.other.solution;

public class Test {
    public static Test t1 = new Test();
    {
        System.out.println("blockA");
    }
    static
    {
        System.out.println("blockB");
    }

    public Test(){
        System.out.println("construction...");
    }
    public static void main(String[] args)
    {
        Test t2 = new Test();
    }
}
