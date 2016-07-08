package LinkedLists;

/**
 * Question 2.5
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * Suppose the digits are stored in forward order. Repeat the above problem.
 */
public class Question_2_5 {

    // O(n)
    public static ListNode addListsInReverseOrder(ListNode n1, ListNode n2) {
        int carry = 0;
        ListNode head = null;
        ListNode previous = null;
        
        while (n1 != null || n2 != null || carry != 0) {
            int value = carry;
            
            if (n1 != null) {
                value += n1.getData();
                n1 = n1.getNext();
            }
            
            if (n2 != null) {
                value += n2.getData();
                n2 = n2.getNext();
            }
            
            carry = value / 10;
            ListNode node = new ListNode(value % 10);
            
            if (previous == null) {
                head = previous = node;
            } else {
                previous.setNext(node);
                previous = node;
            }
        }
        
        return head;
    }
    
    // O(n)
    public static ListNode addListsInOrder(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) {
            return null;
        }
        
        int len1 = getLength(n1);
        int len2 = getLength(n2);
        
        if (len1 < len2) {
            n1 = padLeft(n1, len2 - len1);
        } else {
            n2 = padLeft(n2, len1 - len2);
        }
        
        PartialSum sum = addListsInOrderCore(n1, n2);
        if (sum.carry != 0) {
            sum.sum = insertBefore(sum.sum, sum.carry);
        }
        
        return sum.sum;
    }
    
    private static PartialSum addListsInOrderCore(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) {
            return PartialSum.getInstance();
        }
        
        PartialSum sum = addListsInOrderCore(n1.getNext(), n2.getNext());
        int value = n1.getData() + n2.getData() + sum.carry;
        sum.sum = insertBefore(sum.sum, value % 10);
        sum.carry = value / 10;
        
        return sum;
    }
    
    private static int getLength(ListNode n) {
        int len = 0;
        while (n != null) {
            ++len;
            n = n.getNext();
        }
        
        return len;
    }
    
    private static ListNode padLeft(ListNode head, int length) {
        for (int i = 0; i < length; ++i) {
            head = insertBefore(head, 0);
        }
        
        return head;
    }
    
    private static ListNode insertBefore(ListNode head, int data) {
        ListNode n = new ListNode(data);
        n.setNext(head);
        
        return n;
    }
    
    private static class PartialSum {
        ListNode sum = null;
        int carry = 0;
        
        private PartialSum() {}
        
        public static PartialSum getInstance() {
            return new PartialSum();
        }
    }
}
