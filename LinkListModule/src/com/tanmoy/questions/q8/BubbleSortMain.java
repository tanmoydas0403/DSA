package com.tanmoy.questions.q8;

public class BubbleSortMain {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insert(4);
        list.insert(2);
        list.insert(1);
        list.insert(3);

        System.out.println("Before sorting:");
        list.display();

        list.bubbleSort();

        System.out.println("After sorting:");
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
    int size;

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value) {
                // Swap nodes
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }

            bubbleSort(row, col + 1); // move forward
        } else {
            bubbleSort(row - 1, 0); // next pass
        }
    }
}