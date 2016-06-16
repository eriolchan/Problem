package StacksAndQueues;

import LinkedLists.Node;

public class Stack {
    
    private Node top;
    
    public void push(int data) {
        Node node = new Node(data);
        node.setNext(top);
        top = node;
    }
    
    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        
        int result = top.getData();
        top = top.getNext();
        
        return result;
    }
}
