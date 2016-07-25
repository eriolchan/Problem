package StacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_3_3Test {

    @Test
    public void testStack_OneStack() throws EmptyStackException {
        Question_3_3 stack = new Question_3_3(3);
        
        stack.push(1);
        assertEquals(1, stack.pop());
        
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        
        stack.push(4);
        assertEquals(4, stack.pop());
        assertEquals(2, stack.pop());
    }
    
    @Test
    public void testStack_MultipleStack() throws EmptyStackException {
        Question_3_3 stack = new Question_3_3(2);
        
        stack.push(1);
        assertEquals(1, stack.pop());
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        
        stack.push(4);
        stack.push(5);
        stack.push(6);
        assertEquals(6, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(2, stack.pop());
    }
    
    @Test
    public void testPopAt_CapacityIsOne() throws EmptyStackException {
        Question_3_3 stack = new Question_3_3(1);
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(2, stack.popAt(2));
        assertEquals(3, stack.popAt(2));
        
        stack.push(4);
        stack.push(5);
        assertEquals(1, stack.popAt(1));
        assertEquals(5, stack.popAt(2));
        assertEquals(4, stack.pop());
    }
    
    @Test
    public void testPopAt() throws EmptyStackException {
        Question_3_3 stack = new Question_3_3(2);
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(2, stack.popAt(1));
        assertEquals(5, stack.popAt(2));
        assertEquals(3, stack.popAt(1));
        assertEquals(4, stack.popAt(1));
        assertEquals(1, stack.popAt(1));
    }
    
    @Test
    public void testIsEmpty() throws EmptyStackException {
        Question_3_3 stack = new Question_3_3(3);
        
        assertTrue(stack.isEmpty());
        
        stack.push(1);
        assertFalse(stack.isEmpty());
        
        stack.pop();
        assertTrue(stack.isEmpty());
    }
    
    @Test(expected=EmptyStackException.class)
    public void testPop_StackIsEmpty() throws EmptyStackException {
        Question_3_3 stack = new Question_3_3(1);
        
        stack.pop();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testPopAt_InvalidStackIndex() throws EmptyStackException {
        Question_3_3 stack = new Question_3_3(1);
        
        stack.push(1);
        stack.popAt(2);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testPopAt_AfterShift() throws EmptyStackException {
        Question_3_3 stack = new Question_3_3(2);
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(2, stack.popAt(1));
        
        stack.popAt(2);
    }
}
