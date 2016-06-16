package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_5Test {

    @Test
    public void testFindLoopEntry_AtMiddle() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3, 4, 5 });
        Node n3 = Node.findNode(head, 3);
        Node n5 = Node.findNode(head, 5);
        n5.setNext(n3);
        
        Node actual = Question_2_5.findLoopEntry(head);
        assertEquals(n3, actual);
    }
    
    @Test
    public void testFindLoopEntry_AtBegin() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        Node n3 = Node.findNode(head, 3);
        n3.setNext(head);
        
        Node actual = Question_2_5.findLoopEntry(head);
        assertEquals(head, actual);
    }
    
    @Test
    public void testFindLoopEntry_NoLoop() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3, 4, 5 });
        
        Node actual = Question_2_5.findLoopEntry(head);
        assertNull(actual);
    }
    
    @Test
    public void testFindLoopEntry_OneElement() {
        Node head = Node.createLinkedList(new int[] { 1 });
        
        Node actual = Question_2_5.findLoopEntry(head);
        assertNull(actual);
    }
    
    @Test
    public void testFindLoopEntry_Null() {
        Node head = null;
        
        Node actual = Question_2_5.findLoopEntry(head);
        assertNull(actual);
    }
}
