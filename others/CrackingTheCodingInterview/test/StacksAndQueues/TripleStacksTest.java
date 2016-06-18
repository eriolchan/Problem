package StacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class TripleStacksTest {

    @Test
    public void testTripleStacks1() {
        TripleStacks stacks = new TripleStacks(3);
        
        stacks.push(1, 1);
        stacks.push(2, 2);
        stacks.push(3, 3);
        
        assertEquals(1, stacks.peek(1));
        assertEquals(1, stacks.pop(1));
        
        stacks.push(1, 4);
        stacks.push(2, 5);
        stacks.push(3, 6);
        
        assertEquals(4, stacks.peek(1));
        assertEquals(4, stacks.pop(1));
        assertEquals(5, stacks.peek(2));
        assertEquals(5, stacks.pop(2));
        
        stacks.push(1, 7);
        stacks.push(2, 8);
        stacks.push(3, 9);
        
        assertEquals(7, stacks.peek(1));
        assertEquals(7, stacks.pop(1));
        assertEquals(8, stacks.peek(2));
        assertEquals(8, stacks.pop(2));
        assertEquals(2, stacks.peek(2));
        assertEquals(2, stacks.pop(2));
        assertEquals(9, stacks.peek(3));
        assertEquals(9, stacks.pop(3));
        assertEquals(6, stacks.peek(3));
        assertEquals(6, stacks.pop(3));
        assertEquals(3, stacks.peek(3));
        assertEquals(3, stacks.pop(3));
    }
    
    @Test
    public void testIsEmpty_Stacks1() {
        TripleStacks stacks = new TripleStacks(1);
        
        assertTrue(stacks.isEmpty(1));
        assertTrue(stacks.isEmpty(2));
        assertTrue(stacks.isEmpty(3));
        
        stacks.push(1, 1);
        assertFalse(stacks.isEmpty(1));
        stacks.push(2, 2);
        assertFalse(stacks.isEmpty(2));
        stacks.push(3, 3);
        assertFalse(stacks.isEmpty(3));
        
        stacks.pop(1);
        assertTrue(stacks.isEmpty(1));
        stacks.pop(2);
        assertTrue(stacks.isEmpty(2));
        stacks.pop(3);
        assertTrue(stacks.isEmpty(3));
    }
    
    @Test(expected=IllegalStateException.class)
    public void testPush_Stack1_StackIsFull() {
        TripleStacks stacks = new TripleStacks(1);
        
        stacks.push(1, 1);
        stacks.push(1, 2);
    }
    
    @Test(expected=IllegalStateException.class)
    public void testPop_Stack1_StackIsEmpty() {
        TripleStacks stacks = new TripleStacks(1);
        
        stacks.pop(1);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testPush_Stack1_InvalidStackIndex() {
        TripleStacks stacks = new TripleStacks(1);
        
        stacks.push(4, 1);
    }
    
    @Test
    public void testTripleStacks2() {
        TripleStacks2 stacks = new TripleStacks2(3);
        
        stacks.push(1, 1);
        stacks.push(2, 2);
        stacks.push(3, 3);
        
        assertEquals(1, stacks.peek(1));
        assertEquals(1, stacks.pop(1));
        
        stacks.push(1, 4);
        stacks.push(2, 5);
        stacks.push(3, 6);
        
        assertEquals(4, stacks.peek(1));
        assertEquals(4, stacks.pop(1));
        assertEquals(5, stacks.peek(2));
        assertEquals(5, stacks.pop(2));
        
        stacks.push(1, 7);
        stacks.push(2, 8);
        stacks.push(3, 9);
        
        assertEquals(7, stacks.peek(1));
        assertEquals(7, stacks.pop(1));
        assertEquals(8, stacks.peek(2));
        assertEquals(8, stacks.pop(2));
        assertEquals(2, stacks.peek(2));
        assertEquals(2, stacks.pop(2));
        assertEquals(9, stacks.peek(3));
        assertEquals(9, stacks.pop(3));
        assertEquals(6, stacks.peek(3));
        assertEquals(6, stacks.pop(3));
        assertEquals(3, stacks.peek(3));
        assertEquals(3, stacks.pop(3));
    }
    
    @Test
    public void testTripleStacks2_ExcceedIndivialSize() {
        TripleStacks2 stacks = new TripleStacks2(1);
        
        stacks.push(1, 1);
        stacks.push(1, 2);
        
        assertEquals(2, stacks.peek(1));
        assertEquals(2, stacks.pop(1));
        
        stacks.push(1, 3);
        assertEquals(3, stacks.peek(1));
        assertEquals(3, stacks.pop(1));
        assertEquals(1, stacks.peek(1));
        assertEquals(1, stacks.pop(1));
        
        stacks.push(1, 4);
        assertEquals(4, stacks.peek(1));
        assertEquals(4, stacks.pop(1));
    }
    
    @Test
    public void testIsEmpty_Stack2() {
        TripleStacks2 stacks = new TripleStacks2(1);
        
        assertTrue(stacks.isEmpty(1));
        assertTrue(stacks.isEmpty(2));
        assertTrue(stacks.isEmpty(3));
        
        stacks.push(1, 1);
        assertFalse(stacks.isEmpty(1));
        stacks.push(2, 2);
        assertFalse(stacks.isEmpty(2));
        stacks.push(3, 3);
        assertFalse(stacks.isEmpty(3));
        
        stacks.pop(1);
        assertTrue(stacks.isEmpty(1));
        stacks.pop(2);
        assertTrue(stacks.isEmpty(2));
        stacks.pop(3);
        assertTrue(stacks.isEmpty(3));
    }
    
    @Test(expected=IllegalStateException.class)
    public void testPush_Stack2_StackIsFull() {
        TripleStacks2 stacks = new TripleStacks2(1);
        
        stacks.push(1, 1);
        stacks.push(1, 2);
        stacks.push(1, 3);
        stacks.push(1, 4);
    }
    
    @Test(expected=IllegalStateException.class)
    public void testPush_Stack2_StackIsEmpty() {
        TripleStacks2 stacks = new TripleStacks2(1);
        
        stacks.pop(1);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testPush_Stack2_InvalidStackIndex() {
        TripleStacks2 stacks = new TripleStacks2(1);
        
        stacks.push(4, 1);
    }
}
