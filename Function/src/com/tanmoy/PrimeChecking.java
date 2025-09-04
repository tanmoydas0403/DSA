package com.tanmoy;

import java.util.Scanner;

public class PrimeChecking {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

        if(prime(num))
            System.out.println(num + " :is prime");
        else
            System.out.println(num + " is not prime");
    }

    static boolean prime(int num){
        if(num<=1)
            return false;

        int c=2;

        while(c*c<=num){
            if(num%c==0)
                return false;
            c++;
        }
        return c*c>num;
    }
}
