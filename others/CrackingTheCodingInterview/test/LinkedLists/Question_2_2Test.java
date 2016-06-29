package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_2Test {

    @Test
    public void testFindNthToLast_AtEnd() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        int n = 1;
        
        ListNode actual = Question_2_2.findNthToLast(head, n);
        assertEquals(3, actual.getData());
        
        actual = Question_2_2.findNthToLastRecursively(head, n);
        assertEquals(3, actual.getData());
    }
    
    @Test
    public void testFindNthToLast_AtMiddle() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        int n = 2;
        
        ListNode actual = Question_2_2.findNthToLast(head, n);
        assertEquals(2, actual.getData());
        
        actual = Question_2_2.findNthToLastRecursively(head, n);
        assertEquals(2, actual.getData());
    }
    
    @Test
    public void testFindNthToLast_AtBegin() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        int n = 3;
        
        ListNode actual = Question_2_2.findNthToLast(head, n);
        assertEquals(1, actual.getData());
        
        actual = Question_2_2.findNthToLastRecursively(head, n);
        assertEquals(1, actual.getData());
    }
    
    @Test
    public void testFindNthToLast_OneElement() {
        ListNode head = new ListNode(1);
        int n = 1;
        
        ListNode actual = Question_2_2.findNthToLast(head, n);
        assertEquals(1, actual.getData());
        
        actual = Question_2_2.findNthToLastRecursively(head, n);
        assertEquals(1, actual.getData());
    }
    
    @Test
    public void testFindNthToLast_ExcceedListLength() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        int n = 4;
        
        ListNode actual = Question_2_2.findNthToLast(head, n);
        assertNull(actual);
        
        actual = Question_2_2.findNthToLastRecursively(head, n);
        assertNull(actual);
    }
    
    @Test
    public void testFindNthToLast_InvalidN() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        int n = 0;
        
        ListNode actual = Question_2_2.findNthToLast(head, n);
        assertNull(actual);
        
        actual = Question_2_2.findNthToLastRecursively(head, n);
        assertNull(actual);
        
        n = -1;
        actual = Question_2_2.findNthToLast(head, n);
        assertNull(actual);
        
        actual = Question_2_2.findNthToLastRecursively(head, n);
        assertNull(actual);
    }
    
    @Test
    public void testFindNthToLast_Null() {
        ListNode head = null;
        int n = 1;
        
        ListNode actual = Question_2_2.findNthToLast(head, n);
        assertNull(actual);
        
        actual = Question_2_2.findNthToLastRecursively(head, n);
        assertNull(actual);
    }
}
