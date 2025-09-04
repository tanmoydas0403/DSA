package com.tanmoy;

import java.util.Scanner;

public class MaxNumberFind {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);

        int a=scan.nextInt();
        int b=scan.nextInt();
        int c=scan.nextInt();

//        int max=a;
//
//        if(b>max){
//            max=b;
//        }else if(c>max){
//            max=c;
//        }
//        System.out.println("Max number is: "+max);

//        int max=0;
//        if(a>b){
//            max=a;
//        }else {
//            max=b;
//        }
//
//        if(c>max){
//            max=c;
//        }

        int max=Math.max(a,Math.max(b,c));

        System.out.println("Max is :"+max);

    }
}
