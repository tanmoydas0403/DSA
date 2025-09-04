package com.tanmoy;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 3};
        int target = 4;
//        System.out.println(search(arr, target, 0));
        System.out.println(findAllIndex(arr, target, 0, new ArrayList<>()));

        System.out.println(findAllIndex2(arr, target, 0));
    }

//    static int search(int[] arr, int target, int index){
//        if(index == arr.length) return -1;
//        return arr[index] == target ? index : search(arr, target, index + 1);
//    }

    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> al){
        if(index == arr.length){
            return al;
        }

        if(arr[index] == target){
            al.add(index);
        }
        return findAllIndex(arr, target, index + 1, al);
    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }

        if(arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> ansFormBelowCalls = findAllIndex2(arr, target, index + 1);
        list.addAll(ansFormBelowCalls);
        return list;
    }
}
