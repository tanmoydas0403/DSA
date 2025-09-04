package com.tanmoy.theory.circularLinkList;

public class Main {
    public static void main(String[] args) {
        CLL cll = new CLL();
        cll.insert(10);
        cll.insert(50);
        cll.insert(60);
        cll.insert(23);

        cll.display();

        cll.delete(60);
        cll.display();
    }
}
