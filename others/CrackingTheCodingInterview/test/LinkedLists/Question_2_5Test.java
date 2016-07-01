package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_5Test {

    @Test
    public void testAdd_SameLength() {
        ListNode n1 = ListNodeTest.createLinkedList(new int[] { 3, 1, 5 });
        ListNode n2 = ListNodeTest.createLinkedList(new int[] { 5, 9, 2 });
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 8, 0, 8});
        ListNode actual = Question_2_5.add(n1, n2);
        ListNodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testAdd_DifferentLength() {
        ListNode n1 = ListNodeTest.createLinkedList(new int[] { 2, 1 });
        ListNode n2 = ListNodeTest.createLinkedList(new int[] { 3, 2, 1 });
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 5, 3, 1});
        ListNode actual = Question_2_5.add(n1, n2);
        ListNodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testAdd_ExtraCounter() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = ListNodeTest.createLinkedList(new int[] { 9, 9 });
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 0, 0, 1});
        ListNode actual = Question_2_5.add(n1, n2);
        ListNodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testAdd_OneElement() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        
        ListNode expected = new ListNode(2);
        ListNode actual = Question_2_5.add(n1, n2);
        ListNodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testAdd_Null() {
        ListNode n1 = null;
        ListNode n2 = ListNodeTest.createLinkedList(new int[] { 1, 2, 3 });
        
        ListNode actual = Question_2_5.add(n1, n2);
        ListNodeTest.assertLinkedListEquals(n2, actual);
        
        n2 = null;
        actual = Question_2_5.add(n1, n2);
        assertNull(actual);
    }
}
