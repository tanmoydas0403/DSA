package com.tanmoy;

public class Factorial {
    public static void main(String[] args) {
        int factorial = factorial(5);
        System.out.println(factorial);
    }

    static int factorial(int n){
        if(n <= 1){
            return 1;
        }
//        return n * factorial(n-1);
        return n * factorial(--n);
    }
}
