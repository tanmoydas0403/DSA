package com.tanmoy.theory.singleLinkList;

public class Main {
    public static void main(String[] args) {
        LL l = new LL();
        l.insertFirst(3);
        l.insertFirst(5);
        l.insertFirst(2);
        l.insertFirst(8);
        l.insertLast(99);
        l.insert(100, 3);

        l.display();

        System.out.println("Delete First: " + l.deleteFirst());
        l.display();

        System.out.println("Delete Last: " + l.deleteLast());
        l.display();

        System.out.println("Delete index 2: " + l.delete(2));
        l.display();

        l.insertRecursion(88 , 2);
        l.display();
    }
}
