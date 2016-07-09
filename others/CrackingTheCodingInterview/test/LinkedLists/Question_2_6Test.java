package LinkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question_2_6Test {

    @Test
    public void testIsPalindrome_LengthIsOdd() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 2, 1 });
        
        assertTrue(Question_2_6.isPalindromeByReverse(head));
        assertTrue(Question_2_6.isPalindromeByStack(head));
        assertTrue(Question_2_6.isPalindromeRecursively(head));
    }
    
    @Test
    public void testIsPalindrome_LengthIsEven() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 3, 2, 1 });
        
        assertTrue(Question_2_6.isPalindromeByReverse(head));
        assertTrue(Question_2_6.isPalindromeByStack(head));
        assertTrue(Question_2_6.isPalindromeRecursively(head));
    }
    
    @Test
    public void testIsPalindrome_False() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 4, 1 });
        
        assertFalse(Question_2_6.isPalindromeByReverse(head));
        assertFalse(Question_2_6.isPalindromeByStack(head));
        assertFalse(Question_2_6.isPalindromeRecursively(head));
        
        head = ListNodeTest.createLinkedList(new int[] { 1, 2, 3, 4 });
        assertFalse(Question_2_6.isPalindromeByReverse(head));
        assertFalse(Question_2_6.isPalindromeByStack(head));
        assertFalse(Question_2_6.isPalindromeRecursively(head));
    }
    
    @Test
    public void testIsPalindrome_Same() {
        ListNode head = ListNodeTest.createLinkedList(new int[] { 1, 1, 1, 1 });
        
        assertTrue(Question_2_6.isPalindromeByReverse(head));
        assertTrue(Question_2_6.isPalindromeByStack(head));
        assertTrue(Question_2_6.isPalindromeRecursively(head));
        
        head = ListNodeTest.createLinkedList(new int[] { 1, 1, 1, 1, 1 });
        assertTrue(Question_2_6.isPalindromeByReverse(head));
        assertTrue(Question_2_6.isPalindromeByStack(head));
        assertTrue(Question_2_6.isPalindromeRecursively(head));
    }
    
    @Test
    public void testIsPalindrome_OneElement() {
        ListNode head = new ListNode(1);
        
        assertTrue(Question_2_6.isPalindromeByReverse(head));
        assertTrue(Question_2_6.isPalindromeByStack(head));
        assertTrue(Question_2_6.isPalindromeRecursively(head));
    }
    
    @Test
    public void testIsPalindrome_Null() {
        ListNode head = null;
        
        assertFalse(Question_2_6.isPalindromeByReverse(head));
        assertFalse(Question_2_6.isPalindromeByStack(head));
        assertFalse(Question_2_6.isPalindromeRecursively(head));
    }
}
