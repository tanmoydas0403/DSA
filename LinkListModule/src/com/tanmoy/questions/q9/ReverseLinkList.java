package com.tanmoy.questions.q9;

public class ReverseLinkList {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        System.out.println("Original list:");
        list.display();

        list.reverse();

        System.out.println("Reversed list:");
        list.display();
    }
}

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

class CustomLinkedList {
    Node head;
    Node tail;

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverse() {
        if (head == null || head.next == null) return;
        reverseRecursive(head);
    }

    private void reverseRecursive(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }

        reverseRecursive(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }
}