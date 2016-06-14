package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

    @Test
    public void testAppendToTail() {
        Node actual = new Node(1);
        
        Node expected = Node.createLinkedList(new int[] { 1, 2, 3 });
        actual.appendToTail(2);
        actual.appendToTail(3);
        assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testDeleteNode_NodeAtHead() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        
        Node expected = Node.createLinkedList(new int[] { 2, 3 });
        Node actual = Node.deleteNode(head, 1);
        assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testDeleteNode_NodeAtMiddle() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        
        Node expected = Node.createLinkedList(new int[] { 1, 3 });
        Node actual = Node.deleteNode(head, 2);
        assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testDeleteNode_NodeAtTail() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        
        Node expected = Node.createLinkedList(new int[] { 1, 2 });
        Node actual = Node.deleteNode(head, 3);
        assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testDeleteNode_OnlyHead() {
        Node head = Node.createLinkedList(new int[] { 1 });
        
        Node actual = Node.deleteNode(head, 1);
        assertNull(actual);
    }
    
    @Test
    public void testDeleteNode_NotFound() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        
        Node expected = Node.createLinkedList(new int[] { 1, 2, 3 });
        Node actual = Node.deleteNode(head, 4);
        assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testDeleteNode_Null() {
        Node head = null;
        
        Node actual = Node.deleteNode(head, 1);
        assertNull(actual);
    }
    
    @Test
    public void testEquals() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        
        // Symmetric
        assertEquals(n1, n2);
        assertEquals(n2, n1);
        
        // Transitive
        assertEquals(n2, n3);
        assertEquals(n1, n3);
    }
    
    @Test
    public void testCreateLinkedList_OneElement() {
        Node head = Node.createLinkedList(new int[] { 1 });

        assertNotNull(head);
        assertEquals(1, head.getData());
        assertNull(head.getNext());
    }
    
    @Test
    public void testCreateLinkedList_MultipleElements() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });

        assertNotNull(head);
        assertEquals(1, head.getData());

        assertNotNull(head.getNext());
        assertEquals(2, head.getNext().getData());

        assertNotNull(head.getNext().getNext());
        assertEquals(3, head.getNext().getNext().getData());

        assertNull(head.getNext().getNext().getNext());
    }
    
    public static void assertLinkedListEquals(Node expected, Node actual) {
        while (expected != null && actual != null) {
            assertEquals(expected, actual);
            
            expected = expected.getNext();
            actual = actual.getNext();
        }
        
        assertTrue(expected == null && actual == null);
    }
}
