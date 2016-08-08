package LinkedLists;

/**
 * Question 2.2
 * Implement an algorithm to find the Nth to last element of a singly linked list.
 */
public class Question_2_2 {

    // O(n)
    public static ListNode findNthToLast(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        
        ListNode fast = head;
        for (int i = 0; i < n; ++i) {
            if (fast == null) {
                return null;
            }
            
            fast = fast.getNext();
        }
        
        ListNode slow = head;
        while (fast != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        
        return slow;
    }
    
    // O(n) for both time and space
    public static ListNode findNthToLastRecursively(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        
        Index index = Index.getInstance();
        return findNthToLastRecursivelyCore(head, n, index);
    }
    
    private static ListNode findNthToLastRecursivelyCore(ListNode head, int n, Index index) {
        if (head == null) {
            return null;
        }
        
        ListNode node = findNthToLastRecursivelyCore(head.getNext(), n, index);
        index.value = index.value + 1;
        if (index.value == n) {
            return head;
        }
        
        return node;
    }
    
    private static class Index {
        private int value;
        
        private Index() {
            value = 0;
        }
        
        static Index getInstance() {
            return new Index();
        }
    }
}
