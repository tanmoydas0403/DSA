package com.tanmoy;

public class Shadowing {
    static int x=99;

    public static void main(String[] args) {
        System.out.println(x);
        display();
        display1();
    }

    private static void display1() {
        System.out.println(x);
    }

    static void display(){
        int x=40;
        System.out.println(x);
    }
}
