package com.tanmoy;

public class CheckSorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4};
        if(check(arr, 0)){
            System.out.println("Array is sorted");
        }else {
            System.out.println("Array is not sorted");
        }
    }

    static boolean check(int[] arr, int index){
        //base condition
        if(index == arr.length - 1){
            return true;
        }
        return arr[index] < arr[index + 1] && check(arr , index +1);
    }
}
