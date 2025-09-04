package com.tanmoy;

public class ReverseNumber {
//    public static void main(String[] args) {
//        rev1(12345);
//        System.out.println(sum);
//    }
//
//    static int sum = 0;
//
//    static void rev1(int n){
//        if(n == 0){
//            return;
//        }
//
//        int rem = n % 10;
//        sum = sum * 10 + rem;
//        rev1(n/10);
//    }

    public static void main(String[] args) {
        System.out.println(rev2(1234)); // Output: 4321
    }

    static int rev2(int n){
        int digits = (int)(Math.log10(n)); // No need for +1 when using digits for power
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if(n % 10 == n){
            return n;
        }
        int rem = n % 10;
        return (int)(rem * Math.pow(10, digits)) + helper(n / 10, digits - 1);
    }
}
