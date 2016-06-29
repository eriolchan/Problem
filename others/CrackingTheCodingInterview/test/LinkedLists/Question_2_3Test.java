package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_3Test {

    @Test
    public void testRemove_AtBegin() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        ListNode node = head;
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 2, 3 });
        assertTrue(Question_2_3.remove(node));
        ListNodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemove_AtMiddle() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        ListNode node = head.getNext();
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 3 });
        assertTrue(Question_2_3.remove(node));
        ListNodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemove_AtEnd() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        ListNode node = head.getNext().getNext();
        
        assertFalse(Question_2_3.remove(node));
    }
    
    @Test
    public void testRemove_OneElement() {
        ListNode head = new ListNode(1);
        ListNode node = head;
        
        assertFalse(Question_2_3.remove(node));
    }
    
    @Test
    public void testRemove_Null() {
        ListNode node = null;
        
        assertFalse(Question_2_3.remove(node));
    }
}
