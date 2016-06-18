package StacksAndQueues;

import LinkedLists.Node;

public class Stack {
    
    private Node top;
    
    public void push(int data) {
        Node node = new Node(data);
        node.setNext(top);
        top = node;
    }
    
    public int peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        
        return top.getData();
    }
    
    public int pop() {
        int result = peek();
        top = top.getNext();
        
        return result;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
}
