package com.tanmoy.questions.q1;

public class Main {
    public static void main(String[] args) {
        LL l = new LL();
        l.insertFirst(3);
        l.insertFirst(5);
        l.insertFirst(5);
        l.insertFirst(2);
        l.insertFirst(5);
        l.insertFirst(8);

        l.display();
        l.removeAllDuplicates();
        l.display();
    }
}
