package com.tanmoy.theory;

// import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(scanner);
//        tree.display();
//        System.out.println("------------------------------------------------");
//        tree.prettyDisplay();

        BST bst = new BST();
//        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
//        bst.populate(nums);
//        bst.display();

        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        bst.populateSorted(sortedArray);
//        bst.display();
        bst.preOrder();
    }
}
