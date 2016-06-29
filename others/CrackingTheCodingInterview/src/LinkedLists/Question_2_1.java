package LinkedLists;

import java.util.HashSet;

/**
 * Question 2.1
 * Write code to remove duplicates from an unsorted linked list.
 */
public class Question_2_1 {
    
    // O(n)
    public static void removeDuplicateByCount(ListNode head) {
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
    public static void removeDuplicate(ListNode head) {
        if (head == null) {
            return;
        }
        
        while (head != null) {
            int data = head.getData();
            ListNode previous = head;
            
            while (previous.getNext() != null) {
                if (previous.getNext().getData() == data) {
                    previous.setNext(previous.getNext().getNext());
                } else {
                    previous = previous.getNext();
                }
            }
            
            head = head.getNext();
        }
    }
}
