package StacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

    @Test
    public void testQueue() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        
        assertEquals(1, queue.dequeue());
        
        queue.enqueue(3);
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        
        queue.enqueue(4);
        assertEquals(4, queue.dequeue());
    }
    
    @Test(expected=IllegalStateException.class)
    public void testDequeue_Empty() {
        Queue queue = new Queue();
        
        queue.dequeue();
    }
}
