package StacksAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_3_6Test {

    @Test
    public void testAnimalQueue() throws EmptyQueueException {
        Question_3_6 queue = new Question_3_6();
        queue.enqueue(new Dog("Dog1"));
        queue.enqueue(new Dog("Dog2"));
        queue.enqueue(new Cat("Cat1"));
        queue.enqueue(new Dog("Dog3"));
        queue.enqueue(new Cat("Cat2"));
        queue.enqueue(new Cat("Cat3"));
        
        assertEquals("Dog1", queue.dequeueAny().getName());
        assertEquals("Cat1", queue.dequeueCat().getName());
        assertEquals("Dog2", queue.dequeueDog().getName());
        assertEquals("Cat2", queue.dequeueCat().getName());
        assertEquals("Dog3", queue.dequeueAny().getName());
        assertEquals("Cat3", queue.dequeueAny().getName());
    }
    
    @Test(expected=EmptyQueueException.class)
    public void testDequeueAny_QueueIsEmpty() throws EmptyQueueException {
        Question_3_6 queue = new Question_3_6();
        
        queue.dequeueAny();
    }
    
    @Test(expected=EmptyQueueException.class)
    public void testDequeueDog_NoDog() throws EmptyQueueException {
        Question_3_6 queue = new Question_3_6();
        queue.enqueue(new Cat("Cat"));
        
        queue.dequeueDog();
    }
    
    @Test(expected=EmptyQueueException.class)
    public void testDequeueCat_NoCat() throws EmptyQueueException {
        Question_3_6 queue = new Question_3_6();
        queue.enqueue(new Dog("Cat"));
        
        queue.dequeueCat();
    }

}
