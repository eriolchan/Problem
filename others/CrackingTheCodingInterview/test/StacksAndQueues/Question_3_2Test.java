package StacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_3_2Test {

    @Test
    public void testMinStack() {
        Question_3_2 stack = new Question_3_2();
        
        stack.push(5);
        stack.push(4);
        
        assertEquals(4, stack.min());
        assertEquals(4, stack.peek());
        assertEquals(4, stack.pop());
        
        stack.push(2);
        stack.push(3);
        
        assertEquals(2, stack.min());
        assertEquals(3, stack.peek());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.min());
        assertEquals(2, stack.peek());
        assertEquals(2, stack.pop());
        assertEquals(5, stack.min());
        assertEquals(5, stack.peek());
        assertEquals(5, stack.pop());
        
        stack.push(1);
        assertEquals(1, stack.min());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());
    }
    
    @Test
    public void testMinStack_Same() {
        Question_3_2 stack = new Question_3_2();
        
        stack.push(1);
        stack.push(1);
        
        assertEquals(1, stack.min());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());
        assertEquals(1, stack.min());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());
    }
    
    @Test
    public void testIsEmpty() {
        Question_3_2 stack = new Question_3_2();
        
        assertTrue(stack.isEmpty());
        
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
    
    @Test(expected=IllegalStateException.class)
    public void testPop_StackIsEmpty() {
        Question_3_2 stack = new Question_3_2();
        
        stack.pop();
    }
}
