package StacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

    @Test
    public void testStack() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        
        assertEquals(2, stack.peek());
        assertEquals(2, stack.pop());
        
        stack.push(3);;
        assertEquals(3, stack.peek());
        assertEquals(3, stack.pop());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());
        
        stack.push(4);
        assertEquals(4, stack.peek());
        assertEquals(4, stack.pop());
    }
    
    @Test
    public void testIsEmpty() {
        Stack stack = new Stack();
        
        assertTrue(stack.isEmpty());
        
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
    
    @Test(expected=IllegalStateException.class)
    public void testPop_Empty() {
        Stack stack = new Stack();
        
        stack.pop();
    }
}
