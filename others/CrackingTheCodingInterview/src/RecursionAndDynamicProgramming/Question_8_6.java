package RecursionAndDynamicProgramming;

import java.util.Stack;

/**
 * Question 8.6
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
 * different sizes which can slide onto any tower. The puzzle starts with disks sorted
 * in ascending order of size from top to bottom (i.e., each disk sits on top of an even
 * larger one). You have the following constraints:
 * 1. Only one disk can be moved at a time.
 * 2. A disk is slid off the top of one tower onto another tower.
 * 3. A disk cannot be placed on top of a smaller disk.
 * 
 * Write a program to move the disks from the first tower to the last using Stacks.
 */
public class Question_8_6 {

    private Stack<Integer> stack;
    
    public Question_8_6() {
        this.stack = new Stack<Integer>();
    }
    
    public Stack<Integer> getStack() {
        return stack;
    }
    
    public void moveDisks(int n, Question_8_6 destination, Question_8_6 buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }
    
    public void add(int data) {
        if (!stack.isEmpty() && stack.peek() <= data) {
            throw new IllegalArgumentException();
        }
        
        stack.push(data);
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    private void moveTopTo(Question_8_6 destination) {
        destination.add(stack.pop());
    }
}
