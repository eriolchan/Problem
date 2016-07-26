package LinkedLists;

import java.util.Stack;

/**
 * Question 2.6
 * Implement a function to check if a linked list is a palindrome.
 */
public class Question_2_6 {

    // O(n)
    public static boolean isPalindromeByReverse(ListNode head) {
        if (head == null) {
            return false;
        }
        
        ListNode reversed = reverse(head);
        return compare(head, reversed);
    }
    
    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode next = null;
        while (head != null) {
            ListNode node = new ListNode(head.getData());
            node.setNext(next);
            next = node;
            head = head.getNext();
        }
        
        return next;
    }
    
    private static boolean compare(ListNode n1, ListNode n2) {
        while (n1 != null && n2 != null) {
            if (n1.getData() != n2.getData()) {
                return false;
            }
            
            n1 = n1.getNext();
            n2 = n2.getNext();
        }
        
        return n1 == null && n2 == null;
    }
    
    // O(n)
    public static boolean isPalindromeByStack(ListNode head) {
        if (head == null) {
            return false;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.getNext() != null) {
            stack.push(slow.getData());
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        
        if (fast != null) {
            slow = slow.getNext();
        }
        
        while (slow != null) {
            if (stack.pop() != slow.getData()) {
                return false;
            }
            
            slow = slow.getNext();
        }
        
        return stack.isEmpty();
    }
    
    // O(n)
    public static boolean isPalindromeRecursively(ListNode head) {
        if (head == null) {
            return false;
        }
        
        int len = ListNode.getLength(head);
        Result result = isPalindromeCore(head, len);
        
        return result.result;
    }
    
    private static Result isPalindromeCore(ListNode head, int length) {
        if (head == null || length <= 0) {
            Result result = Result.getInstance();
            result.next = head;
            
            return result;
        } else if (length == 1) {
            Result result = Result.getInstance();
            result.next = head.getNext();
            
            return result;
        }
        
        Result result = isPalindromeCore(head.getNext(), length - 2);
        
        if (!result.result || result.next == null) {
            return result;
        }
        
        result.result = head.getData() == result.next.getData();
        result.next = result.next.getNext();
        
        return result;
    }
    
    private static class Result {
        ListNode next = null;
        boolean result = true;
        
        private Result() {}
        
        public static Result getInstance() {
            return new Result();
        }
    }
}
