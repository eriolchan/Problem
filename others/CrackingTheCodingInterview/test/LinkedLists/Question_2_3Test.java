package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_3Test {

    @Test
    public void testRemove_AtBegin() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        ListNode toBeRemoved = head;
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 2, 3 });
        boolean isSucceed = Question_2_3.remove(toBeRemoved);
        assertTrue(isSucceed);
        ListNodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemove_AtMiddle() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        ListNode toBeRemoved = head.getNext();
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 3 });
        boolean isSucceed = Question_2_3.remove(toBeRemoved);
        assertTrue(isSucceed);
        ListNodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemove_AtEnd() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        ListNode toBeRemoved = head.getNext().getNext();
        
        boolean isSucceed = Question_2_3.remove(toBeRemoved);
        assertFalse(isSucceed);
    }
    
    @Test
    public void testRemove_OneElement() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1 });
        ListNode toBeRemoved = head;
        
        boolean isSucceed = Question_2_3.remove(toBeRemoved);
        assertFalse(isSucceed);
    }
    
    @Test
    public void testRemove_Null() {
        ListNode toBeRemoved = null;
        
        boolean isSucceed = Question_2_3.remove(toBeRemoved);
        assertFalse(isSucceed);
    }
}
