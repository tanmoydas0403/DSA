package com.arrayList;

import java.util.ArrayList;

public class NestedArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> nestedList =new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        nestedList.add(list1);
        nestedList.add(list2);

        System.out.print(nestedList);
    }
}
