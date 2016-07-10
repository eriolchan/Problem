package StacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyStackTest {

    @Test
    public void testMyStack() throws EmptyStackException {
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(1);
        stack.push(2);
        
        assertEquals(new Integer(2), stack.peek());
        assertEquals(new Integer(2), stack.pop());
        
        stack.push(3);;
        assertEquals(new Integer(3), stack.peek());
        assertEquals(new Integer(3), stack.pop());
        assertEquals(new Integer(1), stack.peek());
        assertEquals(new Integer(1), stack.pop());
        
        stack.push(4);
        assertEquals(new Integer(4), stack.peek());
        assertEquals(new Integer(4), stack.pop());
    }
    
    @Test
    public void testIsEmpty() throws EmptyStackException {
        MyStack<Integer> stack = new MyStack<Integer>();
        
        assertTrue(stack.isEmpty());
        
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
    
    @Test(expected=EmptyStackException.class)
    public void testPop_Empty() throws EmptyStackException {
        MyStack<Integer> stack = new MyStack<Integer>();
        
        stack.pop();
    }
}
