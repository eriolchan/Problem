package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_2Test {

    @Test
    public void testFindNthToLast_AtEnd() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        int n = 1;
        
        Node actual = Question_2_2.findNthToLast(head, n);
        assertEquals(3, actual.getData());
    }
    
    @Test
    public void testFindNthToLast_AtMiddle() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        int n = 2;
        
        Node actual = Question_2_2.findNthToLast(head, n);
        assertEquals(2, actual.getData());
    }
    
    @Test
    public void testFindNthToLast_AtBegin() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        int n = 3;
        
        Node actual = Question_2_2.findNthToLast(head, n);
        assertEquals(1, actual.getData());
    }
    
    @Test
    public void testFindNthToLast_OneElement() {
        Node head = Node.createLinkedList(new int[] { 1 });
        int n = 1;
        
        Node actual = Question_2_2.findNthToLast(head, n);
        assertEquals(1, actual.getData());
    }
    
    @Test
    public void testFindNthToLast_ExcceedListLength() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        int n = 4;
        
        Node actual = Question_2_2.findNthToLast(head, n);
        assertNull(actual);
    }
    
    @Test
    public void testFindNthToLast_InvalidN() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        int n = 0;
        
        Node actual = Question_2_2.findNthToLast(head, n);
        assertNull(actual);
        
        n = -1;
        actual = Question_2_2.findNthToLast(head, n);
        assertNull(actual);
    }
    
    @Test
    public void testFindNthToLast_Null() {
        Node head = null;
        int n = 1;
        
        Node actual = Question_2_2.findNthToLast(head, n);
        assertNull(actual);
    }
}
