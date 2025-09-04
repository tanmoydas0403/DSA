package com.tanmoy;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome(123432));
    }

    static boolean palindrome(int n){
        return n == rev(n);
    }

    static int rev(int n){
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
