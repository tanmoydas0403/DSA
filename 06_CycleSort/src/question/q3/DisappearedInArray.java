package question.q3;
/*
Find All Numbers Disappeared in an Array
------------------------------------------
Given an array nums of n integers where nums[i] in the range [1, n],
return an array of all the Integers in the range [1, n] that do not appear
in nums.
* */

import java.util.*;

public class DisappearedInArray {
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 8, 2, 3, 1};
        System.out.println(sort(arr));
    }

    //tips:
    // if range [0, N] -> every element will be at index = value
    // id range [1, N] -> every element will be at index = value - 1

    static List<Integer> sort(int []arr){
        int i = 0;
        while (i < arr.length){
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]){
                swap(arr , i, correct);
            }else{
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int index = 0; index < arr.length; index++) {
            if(arr[index] != index+1){
                ans.add( index + 1 );
            }
        }
        return ans;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

