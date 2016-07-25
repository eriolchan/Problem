package StacksAndQueues;

import java.util.Stack;

/**
 * Question 3.4
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class Question_3_4<T> {

    private Stack<T> inStack;
    private Stack<T> outStack;
    
    public Question_3_4() {
        inStack = new Stack<T>();
        outStack = new Stack<T>();
    }
    
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
    
    public void add(T item) {
        inStack.push(item);
    }
    
    public T remove() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        
        return outStack.pop();
    }
}
