package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_3Test {

    @Test
    public void testRemove_AtBegin() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        Node toBeRemoved = head;
        
        Node expected = Node.createLinkedList(new int[] { 2, 3 });
        boolean isSucceed = Question_2_3.remove(toBeRemoved);
        assertTrue(isSucceed);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemove_AtMiddle() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        Node toBeRemoved = head.getNext();
        
        Node expected = Node.createLinkedList(new int[] { 1, 3 });
        boolean isSucceed = Question_2_3.remove(toBeRemoved);
        assertTrue(isSucceed);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemove_AtEnd() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        Node toBeRemoved = head.getNext().getNext();
        
        boolean isSucceed = Question_2_3.remove(toBeRemoved);
        assertFalse(isSucceed);
    }
    
    @Test
    public void testRemove_OneElement() {
        Node head = Node.createLinkedList(new int[] { 1 });
        Node toBeRemoved = head;
        
        boolean isSucceed = Question_2_3.remove(toBeRemoved);
        assertFalse(isSucceed);
    }
    
    @Test
    public void testRemove_Null() {
        Node toBeRemoved = null;
        
        boolean isSucceed = Question_2_3.remove(toBeRemoved);
        assertFalse(isSucceed);
    }
}
