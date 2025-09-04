package com.tanmoy.questions.q2;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }

    public Node find(int value){
        Node node = head;
        while (node != null){
            if (node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int delete(int index){
        if (index == 0){
            return deleteFirst();
        }

        if (index == size - 1){
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;

        return val;
    }

    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public void insert(int val , int index){
        if(index == 0){
            insertFirst(val);
            return;
        }

        if(index == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void insertLast(int val){

        if(tail == null){
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size += 1;
    }

    //void return type & make changes in LL
    //node return type that values the list node to change the structure
    public void insertRecursion(int val, int index){
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index not allowed: " + index);
        }
        head = insertRec(val, index, head);
    }


    private Node insertRec(int val, int index, Node node){
        if (index == 0 || node == null) {
            size++;
            return new Node(val, node); // Insert here whether index == 0 or we've reached the end
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    private class Node{
        private int value;
        private Node next;

        public Node (int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public static LL mergeSortedLists(LL l1, LL l2) {
        LL result = new LL();
        Node p1 = l1.head;
        Node p2 = l2.head;
        Node dummy = result.new Node(-1); // dummy node to simplify logic
        Node tail = dummy;

        while (p1 != null && p2 != null) {
            if (p1.value <= p2.value) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }

        tail.next = (p1 != null) ? p1 : p2;

        // Set result's head and tail
        result.head = dummy.next;
        Node temp = result.head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        result.tail = temp;

        return result;
    }

    public static LL mergeSortedListsWithoutDuplicates(LL l1, LL l2) {
        LL result = new LL();
        Node p1 = l1.head;
        Node p2 = l2.head;
        Node dummy = result.new Node(-1);
        Node tail = dummy;
        int lastInserted = Integer.MIN_VALUE; // Sentinel value

        while (p1 != null && p2 != null) {
            int val;
            if (p1.value <= p2.value) {
                val = p1.value;
                p1 = p1.next;
            } else {
                val = p2.value;
                p2 = p2.next;
            }

            if (val != lastInserted) {
                tail.next = result.new Node(val);
                tail = tail.next;
                lastInserted = val;
                result.size++;
            }
        }

        // Handle remaining nodes
        Node remaining = (p1 != null) ? p1 : p2;
        while (remaining != null) {
            if (remaining.value != lastInserted) {
                tail.next = result.new Node(remaining.value);
                tail = tail.next;
                lastInserted = remaining.value;
                result.size++;
            }
            remaining = remaining.next;
        }

        result.head = dummy.next;
        result.tail = tail;
        return result;
    }

    //Kunal
    public static LL merge(LL first, LL second){
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while (f != null && s != null){
            if (f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            }else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while (f != null){
            ans.insertLast(f.value);
            f = f.next;
        }
        while (s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }
}
