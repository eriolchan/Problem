package StacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_3_4Test {

    @Test
    public void testQueue() throws EmptyQueueException {
        Question_3_4<Integer> queue = new Question_3_4<Integer>();
        queue.add(1);
        queue.add(2);
        
        assertEquals(new Integer(1), queue.remove());
        
        queue.add(3);
        assertEquals(new Integer(2), queue.remove());
        assertEquals(new Integer(3), queue.remove());
        
        queue.add(4);
        assertEquals(new Integer(4), queue.remove());
    }
    
    @Test
    public void testIsEmpty() throws EmptyQueueException {
        Question_3_4<Integer> queue = new Question_3_4<Integer>();
        
        assertTrue(queue.isEmpty());
        
        queue.add(1);
        assertFalse(queue.isEmpty());
        
        queue.remove();
        assertTrue(queue.isEmpty());
    }
    
    @Test(expected=EmptyQueueException.class)
    public void testRemove_QueueIsEmpty() throws EmptyQueueException {
        Question_3_4<Integer> queue = new Question_3_4<Integer>();
        
        queue.remove();
    }
}
