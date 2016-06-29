package LinkedLists;

/**
 * Question 2.3
 * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
 */
public class Question_2_3 {

    // O(1)
    public static boolean remove(ListNode toBeRemoved) {
        if (toBeRemoved == null || toBeRemoved.getNext() == null) {
            return false;
        }
        
        toBeRemoved.setData(toBeRemoved.getNext().getData());
        toBeRemoved.setNext(toBeRemoved.getNext().getNext());
        
        return true;
    }
}
