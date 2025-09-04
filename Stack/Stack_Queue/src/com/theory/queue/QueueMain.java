package com.theory.queue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CustomQueue customQueue = new CustomQueue(5);
        customQueue.insert(3);
        customQueue.insert(2);
        customQueue.insert(5);
        customQueue.insert(6);
        customQueue.insert(1);

        customQueue.display();

        System.out.println(customQueue.remove());

        customQueue.display();

    }
}
