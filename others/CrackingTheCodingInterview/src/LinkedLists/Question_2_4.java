package LinkedLists;

/**
 * Question 2.4
 * Write code to partition a linked list around value x, such that all node less than x come before
 * all nodes greater than or equal to x. If x is contained within the list, the values of x
 * only need to be after the elements less than x.
 */
public class Question_2_4 {

    // O(n)
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        
        ListNode beforeHead = null;
        ListNode beforeTail = null;
        ListNode afterHead = null;
        ListNode afterTail = null;
        
        while (head != null) {
            ListNode next = head.getNext();
            head.setNext(null);
            
            if (head.getData() < x) {
                if (beforeHead == null) {
                    beforeHead = head;
                    beforeTail = beforeHead;
                } else {
                    beforeTail.setNext(head);
                    beforeTail = head;
                }
            } else {
                if (afterHead == null) {
                    afterHead = head;
                    afterTail = afterHead;
                } else {
                    afterTail.setNext(head);
                    afterTail = head;
                }
            }
            
            head = next;
        }
        
        if (beforeHead == null) {
            return afterHead;
        }
        
        beforeTail.setNext(afterHead);
        
        return beforeHead;
    }
}
