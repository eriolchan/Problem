package StacksAndQueues;

import LinkedLists.Node;

public class Queue {
    
    private Node front;
    private Node back;
    
    public void enqueue(int data) {
        Node node = new Node(data);

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
