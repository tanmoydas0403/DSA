package com.tanmoy;


public class ValueChangeInArray {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4};
        change(arr);
        for(int a:arr){
            System.out.println(a);
        }
    }

    private static void change(int[] ar) {
        ar[0]=99;
    }
}
