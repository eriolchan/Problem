package LinkedLists;

/**
 * Question 2.5
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
 */
public class Question_2_5 {

    // O(n)
    public static Node findLoopEntry(Node head) {
        if (head == null || head.getNext() == null) {
            return null;
        }
        
        Node fast = head;
        Node slow = head;
        
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            
            if (fast == slow) {
                break;
            }
        }
        
        if (fast != slow) {
            return null;
        }
        
        slow = head;
        while (fast != slow) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        
        return slow;
    }
}
