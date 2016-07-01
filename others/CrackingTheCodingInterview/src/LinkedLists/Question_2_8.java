package LinkedLists;

/**
 * Question 2.8
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
 */
public class Question_2_8 {

    // O(n)
    public static ListNode findLoopEntry(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            
            if (fast == slow) {
                break;
            }
        }
        
        if (fast == null || fast.getNext() == null) {
            return null;
        }
        
        fast = head;
        while (fast != slow) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        
        return slow;
    }
}
