package com.array;

public class MaxNumberInRange {
    public static void main(String[] args) {
        int[] arr={12,5,5,1,5,30};

        System.out.println("Max number is "+maxInRange(arr, 1,6));
    }

    public static int maxInRange(int[] arr, int start, int end){
        int maxValue=0;
        if(end<arr.length) {
            while (start <= end) {
                if (arr[start] > maxValue) {
                    maxValue = arr[start];
                }
                start++;
            }
            return maxValue;
        }
        return -1;
    }
}
