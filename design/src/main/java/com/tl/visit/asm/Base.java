package com.tl.visit.asm;


/**
 * 目标对象
 *  使用ASM 技术动态代理一个类，， 对Base类进行增强
 */
public class Base {
    public void process(){
        System.out.println("process");
    }
}
