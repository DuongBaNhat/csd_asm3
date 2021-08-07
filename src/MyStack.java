package service;

import java.util.LinkedList;

class MyStack {
    CityNode head;

    public void push(CityNode x)
    {
        if (x == null) {
            System.out.print("\nHeap Overflow");
            return;
        }
        x.setNextNode(head);
        head = x;

    }

    public boolean isEmpty() {
        return head == null;
    }

    public CityNode pop() {
        if (!isEmpty()) {
            CityNode temp = head;
            head = head.getNextNode();
            return temp;
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }
}
