package com.tanmoy;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        display(1,2,3,4,5,6);
    }
    static void display(int ...v){
        System.out.println(Arrays.toString(v));
    }
}
