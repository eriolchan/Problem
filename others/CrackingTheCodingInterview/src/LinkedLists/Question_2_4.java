package LinkedLists;

/**
 * Question 2.4
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 */
public class Question_2_4 {

    public static Node add(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return null;
        }
        
        // return the copy of n1/n2
        if (n1 == null) {
            return n2;
        }
        
        if (n2 == null) {
            return n1;
        }
        
        int value = n1.getData() + n2.getData();
        int counter = value / 10;
        Node head = new Node(value % 10);
        Node previous = head;
        
        Node first = n1.getNext();
        Node second = n2.getNext();
        for (; first != null && second != null; first = first.getNext(), second = second.getNext()) {
            value = first.getData() + second.getData() + counter;
            counter = value / 10;
            previous.setNext(new Node(value % 10));
            previous = previous.getNext();
        }
        
        if (first != null) {
            AddRemainder(previous, first, counter);
        } else if (second != null) {
            AddRemainder(previous, second, counter);
        } else if (counter != 0) {
            AddCounter(previous, counter);
        }
        
        return head;
    }
    
    private static void AddRemainder(Node previous, Node head, int counter) {
        for (Node node = head; node != null; node = node.getNext()) {
            int value = node.getData() + counter;
            counter = value / 10;
            previous.setNext(new Node(value % 10));
            previous = previous.getNext();
        }
        
        if (counter != 0) {
            AddCounter(previous, counter);
        }
    }
    
    private static void AddCounter(Node previous, int counter) {
        previous.setNext(new Node(counter));
    }
}
