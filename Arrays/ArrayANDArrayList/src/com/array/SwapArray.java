package com.array;

import java.util.Arrays;

public class SwapArray {

    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println("Before swap: "+Arrays.toString(arr));
        reverse(arr);
        System.out.println("After reverse: "+Arrays.toString(arr));
    }

    public static void reverse(int[]arr){
        int start=0, end=arr.length-1;
        while(start<end){
            swap(arr,start,end);
            start++; end--;
        }
    }
    public static void swap(int[] arr, int index1, int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
}
