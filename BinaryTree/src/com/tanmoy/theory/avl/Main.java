package com.tanmoy.theory.avl;

public class Main {
    public static void main(String[] args) {
        AVL tree = new AVL();

        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }

        System.out.println("Height of AVL Tree: " + tree.height());
        System.out.println("Is tree balanced? " + tree.balanced());
    }
}