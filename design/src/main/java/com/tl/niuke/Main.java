package com.tl.niuke;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String graph = in.nextLine();
        graph = in.nextLine();
        char[] chars = graph.toCharArray();
        int green=0;
        int red=0;
        for( int i=0 ; i< length ; i++){
            if( '0' == chars[i]){
                red++;
            }else{
                green++;
            }
        }
        System.out.println(Math.min(green , red));
    }
}
