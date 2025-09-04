package com.tanmoy;

import java.util.Scanner;

public class IsArmstrongNumber {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int num=in.nextInt();
        if(isArmStrong(num))
            System.out.println(num+" is armstrong number");
        else
            System.out.println(num+": is not armstrong number");
    }

    private static boolean isArmStrong(int num) {
        int originalNum=num;
        int sum=0;

        while(num>0){
            int rem=num%10;
            num=num/10;
            sum+=rem*rem*rem;
        }

        return originalNum==sum;
    }


}
