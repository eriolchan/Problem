package LinkedLists;

import java.util.HashSet;

/**
 * Question 2.1
 * Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class Question_2_1 {

    // O(n)
    public static void deleteDuplicateByMap(ListNode head) {
        if (head == null) {
            return;
        }
        
        ListNode previous = null;
        HashSet<Integer> set = new HashSet<Integer>();
        while (head != null) {
            int data = head.getData();
            if (set.contains(data)) {
                previous.setNext(head.getNext());
            } else {
                set.add(data);
                previous = head;
            }
            
            head = head.getNext();
        }
    }
    
    // O(n^2)
    public static void deleteDuplicateInPlace(ListNode head) {
        if (head == null) {
            return;
        }
        
        while (head != null) {
            int data = head.getData();
            ListNode runner = head;
            
            while (runner.getNext() != null) {
                if (runner.getNext().getData() == data) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            
            head = head.getNext();
        }
    }
}
