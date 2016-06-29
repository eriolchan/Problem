package StacksAndQueues;

import LinkedLists.ListNode;

public class Stack {
    
    private ListNode top;
    
    public void push(int data) {
        ListNode node = new ListNode(data);
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
