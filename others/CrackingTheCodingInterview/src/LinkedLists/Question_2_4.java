package LinkedLists;

/**
 * Question 2.4
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 */
public class Question_2_4 {

    // O(n)
    public static Node add(Node n1, Node n2) {
        int carry = 0;
        Node head = null;
        Node previous = null;
        
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
            Node node = new Node(value % 10);
            
            if (previous == null) {
                head = previous = node;
            } else {
                previous.setNext(node);
                previous = node;
            }
        }
        
        return head;
    }
}
