package service;

import java.util.LinkedList;

public class MyQueue {
    CityNode front, rear;

    public MyQueue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(CityNode node) {
        if (this.isEmpty()) {
            this.front = this.rear = node;
            return;
        }
        this.rear.setNextNode(node);
        this.rear = node;
    }

    public CityNode dequeue() {
        if (this.isEmpty()) 
            return null;
        CityNode temp = this.front;
        this.front = this.front.getNextNode();
        if (this.isEmpty()) 
            this.rear = null;
        return temp;
    }
}
