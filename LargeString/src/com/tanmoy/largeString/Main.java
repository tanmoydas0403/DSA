package com.tanmoy.largeString;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //0Constructor 1
        StringBuffer sb = new StringBuffer();

        //Constructor 2
        StringBuffer sb1 = new StringBuffer("Tanmoy Das");

        //Constructor 3
        StringBuffer sb2 = new StringBuffer(30);

        sb.append("WeMakeDevs");
        sb.append(" is nice!");

        sb.insert(2, " Rahul ");

        //sb.replace(1 , 5, "Tanmoy");

        String str = sb.toString();
        System.out.println(str);

        Random random = new Random();
        System.out.println(random.nextFloat());

        int n = 20;
        String name = RandomString.generate(n);
        System.out.println(name);

        //removing white spaces
        String s = "hi T a n m o y";
        System.out.println(s);
        System.out.println(s.replaceAll("\\s", ""));

        //split
        String arr = "Tanmoy Misra Subha";
        String[] names = arr.split(" ");
        System.out.println(Arrays.toString(names));

        //rounding off
        DecimalFormat format = new DecimalFormat("0.0000");
        System.out.println(format.format(7.2));
    }
}
