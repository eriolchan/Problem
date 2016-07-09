package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_7Test {

    @Test
    public void testFindIntersection_AtBegin() {
        ListNode n1 = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 4 });
        ListNode n2 = n1;
        
        ListNode actual = Question_2_7.findIntersection(n1, n2);
        assertSame(n1, actual);
    }
    
    @Test
    public void testFindIntersection_AtMiddle() {
        ListNode n1 = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 4 });
        ListNode n2 = new ListNode(5);
        ListNode n3 = ListNodeTest.findNode(n1, 3);
        n2.setNext(n3);
        
        ListNode actual = Question_2_7.findIntersection(n1, n2);
        assertSame(n3, actual);
    }
    
    @Test
    public void testFindIntersection_AtEnd() {
        ListNode n1 = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 4 });
        ListNode n2 = new ListNode(5);
        ListNode n4 = ListNodeTest.findNode(n1, 4);
        n2.setNext(n4);
        
        ListNode actual = Question_2_7.findIntersection(n1, n2);
        assertSame(n4, actual);
        
        n2 = n4;
        actual = Question_2_7.findIntersection(n1, n2);
        assertSame(n4, actual);
    }
    
    @Test
    public void testFindIntersection_SameLength() {
        ListNode n1 = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 4 });
        ListNode n2 = new ListNode(5);
        ListNode n3 = ListNodeTest.findNode(n1, 2);
        n2.setNext(n3);
        
        ListNode actual = Question_2_7.findIntersection(n1, n2);
        assertSame(n3, actual);
    }
    
    @Test
    public void testFindIntersection_OneElement() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = n1;
        
        ListNode actual = Question_2_7.findIntersection(n1, n2);
        assertSame(n1, actual);
        
        n2 = new ListNode(1);
        actual = Question_2_7.findIntersection(n1, n2);
        assertNull(actual);
    }
    
    @Test
    public void testFindIntersection_NoIntersection() {
        ListNode n1 = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 4 });
        ListNode n2 = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 4 });
        
        ListNode actual = Question_2_7.findIntersection(n1, n2);
        assertNull(actual);
    }
    
    @Test
    public void testFindIntersection_Null() {
        ListNode n1 = null;
        ListNode n2 = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 4 });
        
        ListNode actual = Question_2_7.findIntersection(n1, n2);
        assertNull(actual);
        
        n2 = null;
        actual = Question_2_7.findIntersection(n1, n2);
        assertNull(actual);
    }
}
