package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_3Test {

    @Test
    public void testRemove_AtBegin() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        Node toBeRemoved = head;
        
        Node expected = Node.createLinkedList(new int[] { 2, 3 });
        Question_2_3.remove(toBeRemoved);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemove_AtMiddle() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        Node toBeRemoved = head.getNext();
        
        Node expected = Node.createLinkedList(new int[] { 1, 3 });
        Question_2_3.remove(toBeRemoved);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemove_AtEnd() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        Node toBeRemoved = head.getNext().getNext();
        
        Node expected = Node.createLinkedList(new int[] { 1, 2 });
        Question_2_3.remove(toBeRemoved);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemove_OneElement() {
        Node head = Node.createLinkedList(new int[] { 1 });
        Node toBeRemoved = head;
        
        Question_2_3.remove(toBeRemoved);
        assertNull(head);
    }
    
    @Test
    public void testRemove_Null() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        Node toBeRemoved = null;
        
        Node expected = Node.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_3.remove(toBeRemoved);
        NodeTest.assertLinkedListEquals(expected, head);
    }
}
