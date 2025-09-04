package com.program2;

import java.util.ArrayList;

public class MinIn2DArray {
    public static void main(String[] args) {
        int[][] arr={
                {25,50,7},
                {9,50},
                {5,11,100,20}
        };
        int target=50;
        System.out.println(minCheck(arr));
        int count=searchIndex(arr,target);
        System.out.println("Count: "+count);
    }

    private static int searchIndex(int[][] arr, int target) {
        int count =0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]==target){
                    System.out.println("Index : ["+i+"]"+"["+j+"]");
                    count++;
                }
            }
        }
        return count++;
    }


    private static int minCheck(int[][] arr) {
        int min=arr[0][0];
        for (int[] arr1:arr){
            for(int arr2:arr1){
                if(min>arr2){
                    min=arr2;
                }
            }
        }
        return min;
    }
}
