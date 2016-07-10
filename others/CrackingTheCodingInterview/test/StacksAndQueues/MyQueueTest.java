package StacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyQueueTest {

    @Test
    public void testMyQueue() throws EmptyQueueException {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(1);
        queue.add(2);
        
        assertEquals(new Integer(1), queue.remove());
        
        queue.add(3);
        assertEquals(new Integer(2), queue.remove());
        assertEquals(new Integer(3), queue.remove());
        
        queue.add(4);
        assertEquals(new Integer(4), queue.remove());
    }
    
    @Test(expected=EmptyQueueException.class)
    public void testDequeue_Empty() throws EmptyQueueException {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        queue.remove();
    }
}
