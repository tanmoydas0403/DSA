package com.program2;

import java.util.Arrays;

public class MinimumNumber {
    public static void main(String[] args) {
        int[] arr={18,12,7,70,16};

        System.out.println(min(arr));
    }

    public static int min(int[] arr){
        int min=arr[0];
        int i=0;
        while(i<arr.length){
            if(arr[i]<min)
                min=arr[i];
            i++;
        }
        return min;
    }
}
