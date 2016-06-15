package LinkedLists;

/**
 * Question 2.2
 * Implement an algorithm to find the Nth to last element of a singly linked list.
 */
public class Question_2_2 {

    // O(n)
    public static Node findNthToLast(Node head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        
        Node fast = head;
        for (int i = 0; i < n; ++i) {
            if (fast == null) {
                return null;
            }
            
            fast = fast.getNext();
        }
        
        Node slow = head;
        while (fast != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        
        return slow;
    }
}
