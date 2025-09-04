package com.array;

public class MaximumNumber {
    public static void main(String[] args) {
        int[] arr={12,5,45,1,5,30};
        System.out.println("Maximum number is "+max(arr));
    }

    public static int max(int[] arr){
        int max=arr[0];

        int i=1;
        while(i<arr.length){
            if(arr[i]>max)
                max=arr[i];
            i++;
        }
        return max;
    }
}
