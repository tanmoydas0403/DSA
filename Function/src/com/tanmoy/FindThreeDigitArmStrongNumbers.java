package com.tanmoy;

public class FindThreeDigitArmStrongNumbers {
    public static void main(String[] args) {
        System.out.print("Three Digits all Armstrong Numbers: ");
        for (int i = 100; i <1000 ; i++) {
            if(isArmStrong(i))
                System.out.print(i+" ");
        }
    }

    public static boolean isArmStrong(int num){
        int originalNum = num;
        int sum=0;

        while(num>0){
            int rem = num % 10;
            num = num / 10;
            sum+=rem*rem*rem;
        }
        return sum==originalNum;
    }
}
