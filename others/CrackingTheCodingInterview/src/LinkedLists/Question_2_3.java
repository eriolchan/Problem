package LinkedLists;

/**
 * Question 2.3
 * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
 */
public class Question_2_3 {

    // O(1)
    public static boolean remove(ListNode node) {
        if (node == null || node.getNext() == null) {
            return false;
        }
        
        node.setData(node.getNext().getData());
        node.setNext(node.getNext().getNext());
        
        return true;
    }
}
