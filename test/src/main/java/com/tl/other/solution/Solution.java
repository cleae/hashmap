package com.tl.other.solution;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int money [] = new int [n];
        int attr1 [] = new int [n];
        int attr2 [] = new int [n];
        for(int i = 0; i < n; i++){
            money[i]= sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            attr1[i]= sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            attr2[i]= sc.nextInt();
        }

        int person= sc.nextInt();
        int want_attr [] = new int [person];
        for(int i = 0; i < person; i++){
            want_attr[i]= sc.nextInt();
        }
        int person_num=0;
        boolean access [] = new boolean [n];
        while(person_num<person){
            int ans = Integer.MAX_VALUE;
            int i=0;
            int index=0;
            for( ; i<n; i++){
                if(!access[i] && (want_attr [person_num] == attr1[i] ||want_attr [person_num] == attr2[i] )){
                    if(ans > money[i]){
                        ans=money[i];
                        index=i;
                    }
                }
            }
            if(ans ==Integer.MAX_VALUE){
                System.out.print(-1 +" ");
            }else{
                access[index]=true;
                System.out.print(ans +" ");
            }
            person_num++;
        }
    }}
