package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_1Test {

    @Test
    public void testRemoveDuplicate_NoDuplicate() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3 });
        
        Node expected = Node.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicate(head);
        NodeTest.assertLinkedListEquals(expected, head);
        
        head = Node.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicateByCount(head);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_DuplicateAtBegin() {
        Node head = Node.createLinkedList(new int[] { 1, 1, 2, 3 });
        
        Node expected = Node.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicate(head);
        NodeTest.assertLinkedListEquals(expected, head);
        
        head = Node.createLinkedList(new int[] { 1, 1, 2, 3 });
        Question_2_1.removeDuplicateByCount(head);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_DuplicateAtMiddle() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 1, 3 });
        
        Node expected = Node.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicate(head);
        NodeTest.assertLinkedListEquals(expected, head);
        
        head = Node.createLinkedList(new int[] { 1, 2, 1, 3 });
        Question_2_1.removeDuplicateByCount(head);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_DuplicateAtEnd() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 3, 1 });
        
        Node expected = Node.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicate(head);
        NodeTest.assertLinkedListEquals(expected, head);
        
        head = Node.createLinkedList(new int[] { 1, 2, 3, 1 });
        Question_2_1.removeDuplicateByCount(head);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_MultipleDuplicate() {
        Node head = Node.createLinkedList(new int[] { 1, 1, 2, 1, 3, 1 });
        
        Node expected = Node.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicate(head);
        NodeTest.assertLinkedListEquals(expected, head);
        
        head = Node.createLinkedList(new int[] { 1, 1, 2, 1, 3, 1 });
        Question_2_1.removeDuplicateByCount(head);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_MultipleConsecutiveDuplicate() {
        Node head = Node.createLinkedList(new int[] { 1, 2, 1, 1, 3 });
        
        Node expected = Node.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicate(head);
        NodeTest.assertLinkedListEquals(expected, head);
        
        head = Node.createLinkedList(new int[] { 1, 2, 1, 1, 3 });
        Question_2_1.removeDuplicateByCount(head);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_SameElement() {
        Node head = Node.createLinkedList(new int[] { 1, 1, 1 });
        
        Node expected = Node.createLinkedList(new int[] { 1 });
        Question_2_1.removeDuplicate(head);
        NodeTest.assertLinkedListEquals(expected, head);
        
        head = Node.createLinkedList(new int[] { 1, 1, 1 });
        Question_2_1.removeDuplicateByCount(head);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_OneElement() {
        Node head = Node.createLinkedList(new int[] { 1 });
        
        Node expected = Node.createLinkedList(new int[] { 1 });
        Question_2_1.removeDuplicate(head);
        NodeTest.assertLinkedListEquals(expected, head);
        
        head = Node.createLinkedList(new int[] { 1 });
        Question_2_1.removeDuplicateByCount(head);
        NodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_Null() {
        Node head = null;
        
        Question_2_1.removeDuplicate(head);
        assertNull(head);
        
        Question_2_1.removeDuplicateByCount(head);
        assertNull(head);
    }
}
