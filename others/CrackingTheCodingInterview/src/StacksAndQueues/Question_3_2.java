package StacksAndQueues;

import java.util.Stack;

/**
 * Question 3.2
 * How would you design a stack which, in addition to push and pop,
 * also has a function min() which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 */
public class Question_3_2 extends Stack<Integer> {

    private static final long serialVersionUID = 1L;
    
    private Stack<Integer> minStack;
    
    public Question_3_2() {
        minStack = new Stack<Integer>();
    }
    
    public void push(int value) {
        if (value <= min()) {
            minStack.push(value);
        }
        
        super.push(value);
    }
    
    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            minStack.pop();
        }
        
        return value;
    }
    
    public int min() {
        if (minStack.empty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }
}
