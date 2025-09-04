package com.tanmoy;

public class ThreeDigitsPrimeNumber {
    public static void main(String[] args) {

        for (int i = 100; i <200 ; i++) {
            if(isPrime(i))
                System.out.print(i +" ");
        }
    }

    private static boolean isPrime(int i) {

        if(i<=1)
            return false;

        int c=2;
        while(c*c<=i) {
            if (i % c == 0)
                return false;
            c++;
        }
        return c*c>i;
    }


}
