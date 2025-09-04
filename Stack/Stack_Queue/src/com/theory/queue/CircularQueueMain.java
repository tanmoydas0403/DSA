package com.theory.queue;

public class CircularQueueMain {
    public static void main(String[] args) throws Exception {
        CircularQueue cq = new CircularQueue(5);

        cq.insert(12);
        cq.insert(1);
        cq.insert(2);
        cq.insert(6);
        cq.insert(10);

        cq.display();

        System.out.println(cq.remove());
        cq.insert(100);

        cq.display();

        DynamicQueue dq = new DynamicQueue(2);
        dq.insert(12);
        dq.insert(1);
        dq.insert(2);
        dq.insert(6);
        dq.insert(10);

        dq.display();
    }
}
