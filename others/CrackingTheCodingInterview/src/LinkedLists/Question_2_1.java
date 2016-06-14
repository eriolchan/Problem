package LinkedLists;

import java.util.HashSet;

/**
 * Question 2.1
 * Write code to remove duplicates from an unsorted linked list.
 */
public class Question_2_1 {
    
    // O(n)
    public static void removeDuplicateByCount(Node head) {
        if (head == null) {
            return;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        set.add(head.getData());
        
        Node previous = head;
        while (previous.getNext() != null) {
            if (set.contains(previous.getNext().getData())) {
                previous.setNext(previous.getNext().getNext());
            } else {
                set.add(previous.getNext().getData());
                previous = previous.getNext();
            }
        }
    }
    
    // O(n^2)
    public static void removeDuplicate(Node head) {
        if (head == null) {
            return;
        }
        
        Node current = head;
        while (current != null) {
            int data = current.getData();
            Node previous = current;
            
            while (previous.getNext() != null) {
                if (previous.getNext().getData() == data) {
                    previous.setNext(previous.getNext().getNext());
                } else {
                    previous = previous.getNext();
                }
            }
            
            current = current.getNext();
        }
    }
}
