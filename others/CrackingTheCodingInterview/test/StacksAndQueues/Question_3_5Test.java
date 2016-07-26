package StacksAndQueues;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class Question_3_5Test {

    @Test
    public void testSort_NoDuplicate() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        
        Stack<Integer> actual = Question_3_5.sort(stack);
        assertFalse(actual.isEmpty());
        assertEquals(new Integer(1), actual.pop());
        assertEquals(new Integer(2), actual.pop());
        assertEquals(new Integer(3), actual.pop());
        assertEquals(new Integer(4), actual.pop());
        assertEquals(new Integer(5), actual.pop());
    }
    
    @Test
    public void testSort_HasDuplicate() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(1);
        stack.push(4);
        stack.push(1);
        stack.push(3);
        
        Stack<Integer> actual = Question_3_5.sort(stack);
        assertFalse(actual.isEmpty());
        assertEquals(new Integer(1), actual.pop());
        assertEquals(new Integer(1), actual.pop());
        assertEquals(new Integer(2), actual.pop());
        assertEquals(new Integer(3), actual.pop());
        assertEquals(new Integer(4), actual.pop());
    }
    
    @Test
    public void testSort_InOrder() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        
        Stack<Integer> actual = Question_3_5.sort(stack);
        assertFalse(actual.isEmpty());
        assertEquals(new Integer(1), actual.pop());
        assertEquals(new Integer(2), actual.pop());
        assertEquals(new Integer(3), actual.pop());
        assertEquals(new Integer(4), actual.pop());
        assertEquals(new Integer(5), actual.pop());
    }
    
    @Test
    public void testSort_InReverseOrder() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        Stack<Integer> actual = Question_3_5.sort(stack);
        assertFalse(actual.isEmpty());
        assertEquals(new Integer(1), actual.pop());
        assertEquals(new Integer(2), actual.pop());
        assertEquals(new Integer(3), actual.pop());
        assertEquals(new Integer(4), actual.pop());
        assertEquals(new Integer(5), actual.pop());
    }
    
    @Test
    public void testSort_Same() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(1);
        stack.push(1);
        
        Stack<Integer> actual = Question_3_5.sort(stack);
        assertFalse(actual.isEmpty());
        assertEquals(new Integer(1), actual.pop());
        assertEquals(new Integer(1), actual.pop());
        assertEquals(new Integer(1), actual.pop());
    }
    
    @Test
    public void testSort_OneElement() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        
        Stack<Integer> actual = Question_3_5.sort(stack);
        assertFalse(actual.isEmpty());
        assertEquals(new Integer(1), actual.pop());
    }
    
    @Test
    public void testSort_Empty() {
        Stack<Integer> stack = new Stack<Integer>();
        
        Stack<Integer> actual = Question_3_5.sort(stack);
        assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testSort_Null() {
        Stack<Integer> stack = null;
        
        Stack<Integer> actual = Question_3_5.sort(stack);
        assertNull(actual);
    }

}
