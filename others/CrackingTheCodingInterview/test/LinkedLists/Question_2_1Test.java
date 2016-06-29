package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_1Test {

    @Test
    public void testRemoveDuplicate_NoDuplicate() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicate(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
        
        head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicateByCount(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_DuplicateAtBegin() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 1, 2, 3 });
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicate(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
        
        head = ListNodeTest.createLinkedList(new int[] { 1, 1, 2, 3 });
        Question_2_1.removeDuplicateByCount(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_DuplicateAtMiddle() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 1, 3 });
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicate(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
        
        head = ListNodeTest.createLinkedList(new int[] { 1, 2, 1, 3 });
        Question_2_1.removeDuplicateByCount(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_DuplicateAtEnd() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 1 });
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicate(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
        
        head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 1 });
        Question_2_1.removeDuplicateByCount(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_MultipleDuplicate() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 1, 2, 1, 3, 1 });
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicate(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
        
        head = ListNodeTest.createLinkedList(new int[] { 1, 1, 2, 1, 3, 1 });
        Question_2_1.removeDuplicateByCount(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_MultipleConsecutiveDuplicate() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 1, 1, 3 });
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        Question_2_1.removeDuplicate(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
        
        head = ListNodeTest.createLinkedList(new int[] { 1, 2, 1, 1, 3 });
        Question_2_1.removeDuplicateByCount(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_SameElement() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 1, 1 });
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1 });
        Question_2_1.removeDuplicate(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
        
        head = ListNodeTest.createLinkedList(new int[] { 1, 1, 1 });
        Question_2_1.removeDuplicateByCount(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_OneElement() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1 });
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1 });
        Question_2_1.removeDuplicate(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
        
        head = ListNodeTest.createLinkedList(new int[] { 1 });
        Question_2_1.removeDuplicateByCount(head);
        ListNodeTest.assertLinkedListEquals(expected, head);
    }
    
    @Test
    public void testRemoveDuplicate_Null() {
        ListNode head = null;
        
        Question_2_1.removeDuplicate(head);
        assertNull(head);
        
        Question_2_1.removeDuplicateByCount(head);
        assertNull(head);
    }
}
