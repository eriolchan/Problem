package StacksAndQueues;

import LinkedLists.ListNode;

public class Queue {
    
    private ListNode front;
    private ListNode back;
    
    public void enqueue(int data) {
        ListNode node = new ListNode(data);
        
        if (front == null) {
            front = back = node;
        } else {
            back.setNext(node);
            back = node;
        }
    }
    
    public int dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        
        int result = front.getData();
        front = front.getNext();
        
        return result;
    }
}
