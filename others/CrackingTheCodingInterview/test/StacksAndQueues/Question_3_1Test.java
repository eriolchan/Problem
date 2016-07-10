package StacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_3_1Test {

    @Test
    public void testTripleStacks1() throws FullStackException, EmptyStackException {
        Question_3_1 stacks = new Question_3_1(3);
        
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
    public void testIsEmpty_Stacks1() throws FullStackException, EmptyStackException {
        Question_3_1 stacks = new Question_3_1(1);
        
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
    
    @Test
    public void testIsFull_Stack1() throws FullStackException {
        Question_3_1 stacks = new Question_3_1(1);
        
        stacks.push(1, 1);
        assertTrue(stacks.isFull(1));
    }
    
    @Test(expected=FullStackException.class)
    public void testPush_Stack1_StackIsFull() throws FullStackException {
        Question_3_1 stacks = new Question_3_1(1);
        
        stacks.push(1, 1);
        stacks.push(1, 2);
    }
    
    @Test(expected=EmptyStackException.class)
    public void testPop_Stack1_StackIsEmpty() throws EmptyStackException {
        Question_3_1 stacks = new Question_3_1(1);
        
        stacks.pop(1);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testPush_Stack1_InvalidStackIndex() throws FullStackException {
        Question_3_1 stacks = new Question_3_1(1);
        
        stacks.push(4, 1);
    }
    
    @Test
    public void testTripleStacks2() throws FullStackException, EmptyStackException {
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
    public void testTripleStacks2_ExcceedDefaultSize() throws FullStackException, EmptyStackException {
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
    public void testIsEmpty_Stack2() throws FullStackException, EmptyStackException {
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
    
    @Test
    public void testIsFull_Stack2() throws FullStackException {
        TripleStacks2 stacks = new TripleStacks2(1);
        
        stacks.push(1, 1);
        stacks.push(1, 2);
        stacks.push(1, 3);
        assertTrue(stacks.isFull(1));
    }
    
    @Test(expected=FullStackException.class)
    public void testPush_Stack2_StackIsFull() throws FullStackException {
        TripleStacks2 stacks = new TripleStacks2(1);
        
        stacks.push(1, 1);
        stacks.push(1, 2);
        stacks.push(1, 3);
        stacks.push(1, 4);
    }
    
    @Test(expected=EmptyStackException.class)
    public void testPush_Stack2_StackIsEmpty() throws EmptyStackException {
        TripleStacks2 stacks = new TripleStacks2(1);
        
        stacks.pop(1);
    }
    
    @Test
    public void testTripleStacks3() throws FullStackException, EmptyStackException {
        TripleStacks3 stacks = new TripleStacks3(3);
        
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
    public void testTripleStacks3_ExcceedDefaultSize() throws FullStackException, EmptyStackException {
        TripleStacks3 stacks = new TripleStacks3(1);
        
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
    public void testIsEmpty_Stack3() throws FullStackException, EmptyStackException {
        TripleStacks3 stacks = new TripleStacks3(1);
        
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
    
    @Test
    public void testIsFull_Stack3() throws FullStackException {
        TripleStacks3 stacks = new TripleStacks3(1);
        
        stacks.push(1, 1);
        stacks.push(1, 2);
        stacks.push(1, 3);
        assertTrue(stacks.isFull(1));
    }
    
    @Test(expected=FullStackException.class)
    public void testPush_Stack3_StackIsFull() throws FullStackException {
        TripleStacks3 stacks = new TripleStacks3(1);
        
        stacks.push(1, 1);
        stacks.push(1, 2);
        stacks.push(1, 3);
        stacks.push(1, 4);
    }
    
    @Test(expected=EmptyStackException.class)
    public void testPush_Stack3_StackIsEmpty() throws EmptyStackException {
        TripleStacks3 stacks = new TripleStacks3(1);
        
        stacks.pop(1);
    }
}
