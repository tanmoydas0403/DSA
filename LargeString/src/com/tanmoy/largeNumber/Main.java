package com.tanmoy.largeNumber;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
//        BI();
        BD();
    }

    static void BD() {
        double x = 0.03;
        double y = 0.04;
        double ans = y - x;
        System.out.println(ans);

        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal ans1 = Y.subtract(X);
        System.out.println(ans1);
        System.out.println(Y.pow(2));
    }

    static void BI(){
        int a = 30;
        int b = 67;

        BigInteger A = BigInteger.valueOf(33);
        BigInteger B = BigInteger.valueOf(3);
        BigInteger C = new BigInteger("451231115111156");

        //constants
        BigInteger D = BigInteger.ONE;

        //add
        BigInteger add = A.add(B);
        System.out.println(add);

        System.out.println(C);

        BigInteger add1 = C.add(A);
        System.out.println(add1);

        BigInteger multiply = C.multiply(A);
        System.out.println(multiply);

        BigInteger subtract = C.subtract(A);
        System.out.println(subtract);

        BigInteger remainder = C.remainder(A);
        System.out.println(remainder);

        if (A.compareTo(C) < 0){
            System.out.println("YES");
        }

        System.out.println(Factorial.fact(123));
    }
}
