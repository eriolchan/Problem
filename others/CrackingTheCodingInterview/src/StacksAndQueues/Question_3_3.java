package StacksAndQueues;

import java.util.ArrayList;

/**
 * Implement a data structure SetOfStacks which is composed of several stacks and
 * should create a new stack once the previous one exceeds capacity.
 * push() and pop() should behavior identically to a single stack.
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on
 * a specific sub stack.
 */
public class Question_3_3 {

    private ArrayList<Stack> stacks;
    private int capacity;
    
    public Question_3_3(int capacity) {
        this.stacks = new ArrayList<Stack>();
        this.capacity = capacity;
    }
    
    public boolean isEmpty() {
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }
    
    public void push(int value) {
        Stack last = getLastStack();
        if (last != null && !last.isFull()) {
            last.push(value);
        } else {
            Stack stack = new Stack(capacity);
            stack.push(value);
            stacks.add(stack);
        }
    }
    
    public int pop() throws EmptyStackException {
        Stack last = getLastStack();
        if (last == null) {
            throw new EmptyStackException();
        }
        
        int result = last.pop();
        if (last.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        
        return result;
    }
    
    public int popAt(int stackNum) throws EmptyStackException {
        if (stackNum < 1 || stackNum > stacks.size()) {
            throw new IllegalArgumentException("Stack index is not valid");
        }
        
        return leftShift(stackNum - 1, true);
    }
    
    private int leftShift(int index, boolean removeTop) throws EmptyStackException {
        Stack stack = stacks.get(index);
        int result = removeTop ? stack.pop() : stack.removeBottom();
        
        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int value = leftShift(index + 1, false);
            stack.push(value);
        }
        
        return result;
    }
    
    private Stack getLastStack() {
        int size = stacks.size();
        return size == 0 ? null : stacks.get(size - 1);
    }
    
    private class Stack {
        private int capacity;
        private int size;
        private Node bottom;
        private Node top;
        
        public Stack(int capacity) {
            this.capacity = capacity;
            this.size = 0;
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public boolean isFull() {
            return size == capacity;
        }
        
        public boolean push(int value) {
            if (isFull()) {
                return false;
            }
            
            ++size;
            Node node = new Node(value);
            if (size == 1) {
                bottom = node;
            }
            
            join(node, top);
            top = node;
            
            return true;
        }
        
        public int pop() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            
            int result = top.value;
            top = top.below;
            --size;
            
            if (top != null) {
                top.above = null;
            }
            
            return result;
        }
        
        public int removeBottom() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            
            int result = bottom.value;
            bottom = bottom.above;
            --size;
            
            if (bottom != null) {
                bottom.below = null;
            }
            
            return result;
        }
        
        private void join(Node above, Node below) {
            if (below != null) {
                below.above = above;
            }
            
            if (above != null) {
                above.below = below;
            }
        }
        
        private class Node {
            private int value;
            private Node above;
            private Node below;
            
            public Node(int value) {
                this.value = value;
                this.above = null;
                this.below = null;
            }
        }
    }
}
