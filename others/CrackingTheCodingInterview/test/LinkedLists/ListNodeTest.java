package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListNodeTest {

    @Test
    public void testAppendToTail() {
        ListNode actual = new ListNode(1);
        
        ListNode expected = createLinkedList(new int[] { 1, 2, 3 });
        actual.appendToTail(2);
        actual.appendToTail(3);
        assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testDeleteNode_NodeAtHead() {
        ListNode head = createLinkedList(new int[] { 1, 2, 3 });
        
        ListNode expected = createLinkedList(new int[] { 2, 3 });
        ListNode actual = ListNode.deleteNode(head, 1);
        assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testDeleteNode_NodeAtMiddle() {
        ListNode head = createLinkedList(new int[] { 1, 2, 3 });
        
        ListNode expected = createLinkedList(new int[] { 1, 3 });
        ListNode actual = ListNode.deleteNode(head, 2);
        assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testDeleteNode_NodeAtTail() {
        ListNode head = createLinkedList(new int[] { 1, 2, 3 });
        
        ListNode expected = createLinkedList(new int[] { 1, 2 });
        ListNode actual = ListNode.deleteNode(head, 3);
        assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testDeleteNode_OnlyHead() {
        ListNode head = new ListNode(1);
        
        ListNode actual = ListNode.deleteNode(head, 1);
        assertNull(actual);
    }
    
    @Test
    public void testDeleteNode_NotFound() {
        ListNode head = createLinkedList(new int[] { 1, 2, 3 });
        
        ListNode expected = createLinkedList(new int[] { 1, 2, 3 });
        ListNode actual = ListNode.deleteNode(head, 4);
        assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testDeleteNode_Null() {
        ListNode head = null;
        
        ListNode actual = ListNode.deleteNode(head, 1);
        assertNull(actual);
    }
    
    @Test
    public void testEquals() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        
        // Symmetric
        assertEquals(n1, n2);
        assertEquals(n2, n1);
        
        // Transitive
        assertEquals(n2, n3);
        assertEquals(n1, n3);
    }
    
    @Test
    public void testLength_Odd() {
        ListNode head = createLinkedList(new int[] { 1, 2, 3 });
        
        assertEquals(3, ListNode.getLength(head));
    }
    
    @Test
    public void testLength_Even() {
        ListNode head = createLinkedList(new int[] { 1, 2, 3, 4 });
        
        assertEquals(4, ListNode.getLength(head));
    }
    
    @Test
    public void testLength_One() {
        ListNode head = new ListNode(1);
        
        assertEquals(1, ListNode.getLength(head));
    }
    
    @Test
    public void testLength_Null() {
        ListNode head = null;
        
        assertEquals(0, ListNode.getLength(head));
    }
    
    public static void assertLinkedListEquals(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            assertEquals(expected, actual);
            
            expected = expected.getNext();
            actual = actual.getNext();
        }
        
        assertTrue(expected == null && actual == null);
    }
    
    // Assume array is not null or empty.
    public static ListNode createLinkedList(int[] elements) {
        ListNode head = new ListNode(elements[0]);
        ListNode tail = head;
        
        for (int i = 1; i < elements.length; ++i) {
            tail.setNext(new ListNode(elements[i]));
            tail = tail.getNext();
        }
        
        return head;
    }
    
    public static ListNode findNode(ListNode head, int data) {
        if (head == null) {
            return null;
        }
        
        while (head != null && head.getData() != data) {
            head = head.getNext();
        }
        
        return head;
    }
}
