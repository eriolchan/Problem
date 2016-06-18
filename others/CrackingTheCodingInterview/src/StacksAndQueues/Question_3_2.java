package StacksAndQueues;

/**
 * Question 3.2
 * How would you design a stack which, in addition to push and pop,
 * also has a function min() which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 */
public class Question_3_2 {
    
    private Stack stack;
    private Stack minStack;
    
    public Question_3_2() {
        stack = new Stack();
        minStack = new Stack();
    }
    
    public void push(int data) {
        stack.push(data);
        
        if (minStack.isEmpty() || data <= min()) {
            minStack.push(data);
        }
    }
    
    public int pop() {
        int result = stack.pop();
        if (result == minStack.peek()) {
            minStack.pop();
        }
        
        return result;
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    public int min() {
        return minStack.peek();
    }
}
