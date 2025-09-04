package com.tanmoy.theory.doublyLinkList;

public class Main {
    public static void main(String[] args) {
        DLL dl = new DLL();

        dl.insertFirst(3);
        dl.insertFirst(5);
        dl.insertFirst(2);
        dl.insertFirst(8);
        dl.display();
        System.out.println("----------------------------");

        dl.insertLast(9);
        dl.display();

        System.out.println("-----------------------------");
        dl.insert(9, 65);
        dl.display();

    }
}
