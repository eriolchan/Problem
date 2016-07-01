package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_4Test {

    @Test
    public void testPartition_PivotNotExist() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 5, 3, 7 });
        int x = 4;
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 3, 5, 7 });
        ListNode actual = Question_2_4.partition(head, x);
        ListNodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testPartition_PivotExist() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 4, 1, 5, 3, 7 });
        int x = 4;
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 3, 4, 5, 7 });
        ListNode actual = Question_2_4.partition(head, x);
        ListNodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testPartition_PivotExistMultipleTimes() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 4, 1, 5, 4, 3, 7 });
        int x = 4;
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 3, 4, 5, 4, 7 });
        ListNode actual = Question_2_4.partition(head, x);
        ListNodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testPartition_AllLessThanPivot() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 5, 3, 7 });
        int x = 9;
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 5, 3, 7 });
        ListNode actual = Question_2_4.partition(head, x);
        ListNodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testPartition_AllMoreThanPivot() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 5, 3, 7 });
        int x = 0;
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 1, 5, 3, 7 });
        ListNode actual = Question_2_4.partition(head, x);
        ListNodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testPartition_Same() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 5, 5, 5 });
        int x = 5;
        
        ListNode expected = ListNodeTest.createLinkedList(new int[] { 5, 5, 5 });
        ListNode actual = Question_2_4.partition(head, x);
        ListNodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testPartition_OneElement() {
        ListNode head = new ListNode(1);
        int x = 2;
        
        ListNode expected = new ListNode(1);
        ListNode actual = Question_2_4.partition(head, x);
        ListNodeTest.assertLinkedListEquals(expected, actual);
    }
    
    @Test
    public void testPartition_Null() {
        ListNode head = null;
        int x = 1;
        
        ListNode actual = Question_2_4.partition(head, x);
        assertNull(actual);
    }
}
