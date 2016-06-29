package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_5Test {

    @Test
    public void testFindLoopEntry_AtMiddle() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 4, 5 });
        ListNode n3 = ListNodeTest.findNode(head, 3);
        ListNode n5 = ListNodeTest.findNode(head, 5);
        n5.setNext(n3);
        
        ListNode actual = Question_2_5.findLoopEntry(head);
        assertEquals(n3, actual);
    }
    
    @Test
    public void testFindLoopEntry_AtBegin() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        ListNode n3 = ListNodeTest.findNode(head, 3);
        n3.setNext(head);
        
        ListNode actual = Question_2_5.findLoopEntry(head);
        assertEquals(head, actual);
    }
    
    @Test
    public void testFindLoopEntry_NoLoop() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 4, 5 });
        
        ListNode actual = Question_2_5.findLoopEntry(head);
        assertNull(actual);
    }
    
    @Test
    public void testFindLoopEntry_OneElement() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1 });
        
        ListNode actual = Question_2_5.findLoopEntry(head);
        assertNull(actual);
    }
    
    @Test
    public void testFindLoopEntry_Null() {
        ListNode head = null;
        
        ListNode actual = Question_2_5.findLoopEntry(head);
        assertNull(actual);
    }
}
