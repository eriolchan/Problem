package LinkedLists;

public class Node {

    private int data;
    private Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    
    public Node getNext() {
        return next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    @Override
    public int hashCode() {
        return data;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Node)) {
            return false;
        }
        
        final Node other = (Node)obj;
        
        return this.data == other.data;
    }
    
    // O(n)
    public void appendToTail(int data) {
        Node end = new Node(data);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        
        n.next = end;
    }
    
    /**
     * Assume there is one and only one element in the list whose data matches.
     * O(n)
     */
    public static Node deleteNode(Node head, int data) {
        if (head == null) {
            return null;
        }
        
        if (head.data == data) {
            head = head.next;
        } else {
            Node node = head;
            while (node.next != null) {
                if (node.next.data == data) {
                    node.next = node.next.next;
                    break;
                }
                
                node = node.next;
            }
        }
        
        return head;
    }
    
    /**
     * Assume elements array is null or empty.
     */
    public static Node createLinkedList(int[] elements) {
        Node head = new Node(elements[0]);
        Node tail = head;

        for (int i = 1; i < elements.length; ++i) {
            tail.next = new Node(elements[i]);
            tail = tail.next;
        }
        
        return head;
    }
}
