package com.tanmoy.questions.q2;

public class Main {
    public static void main(String[] args) {
        LL l1 = new LL();
        l1.insertLast(1);
        l1.insertLast(3);
        l1.insertLast(5);
        System.out.println("List 1: ");
        l1.display();

        LL l2 = new LL();
        l2.insertLast(2);
        l2.insertLast(4);
        l2.insertLast(6);
        System.out.println("List 2: ");
        l2.display();

        LL merged = LL.mergeSortedLists(l1, l2);
        System.out.println("Merge List: ");
        merged.display();

        LL duplicateR = LL.mergeSortedListsWithoutDuplicates(l1, l2);
        System.out.println("Merge List Remove Duplicate: ");
        duplicateR.display();

//        LL kunal = LL.merge(l1, l2);
//        kunal.display();
    }
}
