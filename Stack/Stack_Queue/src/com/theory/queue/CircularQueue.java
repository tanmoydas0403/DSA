package com.theory.queue;

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int end = 0; // ✅ Start from 0
    protected int front = 0;
    protected int size = 0;

    public CircularQueue(){
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size){
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        this.data = new int[size];
    }

    public boolean insert(int item){
        if (isFull()){
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }

        int removed = data[front];

        front = front + 1 % data.length;
        size--;

        return removed;
    }

    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }

        return data[front];
    }

    public void display(){

        if (isEmpty()){
            System.out.println("Empty");
            return;
        }

        int i = front;
        do {
            System.out.print(data[i] + " <- ");
            i++;
            i %= data.length;
        }while ( i != end);
        System.out.println("END");
    }

    public boolean isFull() {
        return size == data.length; // ✅ end points to next free index
    }

    private boolean isEmpty(){
        return size == 0; // ✅ No elements inserted yet
    }
}
